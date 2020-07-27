package com.checkmarx.sonar.sensor.encryption;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

import javax.crypto.*;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Arrays;
import java.util.Base64;

// TODO: Implement 256-bit version like: http://securejava.wordpress.com/2012/10/25/aes-256/
public class AesUtil {
    private static SecretKeySpec secretKey;
    private static byte[] key;
    private static final int GCM_IV_LENGTH = 12;
    private static final int GCM_TAG_LENGTH = 16;
    private static final String CHARSET = "UTF-8";
    private static final String ALGORITHM = "SHA-1";
    private static final int LENGTH = 16;
    private static final String AES = "AES";

    private static void setKey(String myKey) {
        MessageDigest sha = null;
        try {
            key = myKey.getBytes(CHARSET);
            sha = MessageDigest.getInstance(ALGORITHM);
            key = sha.digest(key);
            key = Arrays.copyOf(key, LENGTH);
            secretKey = new SecretKeySpec(key, AES);
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            System.err.println("Error while setting key: " + e.toString());
        }
    }

    public static String encrypt(String strToEncrypt, String secret) {
        try {
            setKey(secret);

            byte[] iv = new byte[GCM_IV_LENGTH];
            (new SecureRandom()).nextBytes(iv);

            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            GCMParameterSpec ivSpec = new GCMParameterSpec(GCM_TAG_LENGTH * Byte.SIZE, iv);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey,ivSpec);

            byte[] cipherText = cipher.doFinal(strToEncrypt.getBytes("UTF8"));
            byte[] encrypted = new byte[iv.length + cipherText.length];

            System.arraycopy(iv, 0, encrypted, 0, iv.length);
            System.arraycopy(cipherText, 0, encrypted, iv.length, cipherText.length);

            return java.util.Base64.getEncoder().encodeToString(encrypted);
        } catch (Exception e) {
            System.err.println("Error while encrypting: " + e.toString());
        }
        return null;
    }

    public static String decrypt(String strToDecrypt, String secret) {
        try {
            setKey(secret);

            byte[] decoded = Base64.getDecoder().decode(strToDecrypt);

            byte[] iv = Arrays.copyOfRange(decoded, 0, GCM_IV_LENGTH);

            Cipher cipher = Cipher.getInstance("AES/GCM/NoPADDING");
            GCMParameterSpec ivSpec = new GCMParameterSpec(GCM_TAG_LENGTH * Byte.SIZE, iv);
            cipher.init(Cipher.DECRYPT_MODE, secretKey,ivSpec);

            byte[] cipherText = cipher.doFinal(decoded, GCM_IV_LENGTH, decoded.length - GCM_IV_LENGTH);

            return new String(cipherText, "UTF8");
        } catch (Exception e) {
            System.err.println("Error while decrypting: " + e.toString());
        }
        return null;
    }

    public static String generateKey() {
        try {
            KeyGenerator kgen = KeyGenerator.getInstance("AES");
            kgen.init(128);
            return Base64.getEncoder().encodeToString(kgen.generateKey().getEncoded());
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException(e.toString());
        }
    }

}
