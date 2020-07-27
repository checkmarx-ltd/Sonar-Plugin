package com.checkmarx.sonar.sensor.encryption;

import com.trilead.ssh2.crypto.cipher.AES;

import static org.junit.jupiter.api.Assertions.*;

class AesUtilTest {

    private String key = "123";
    private String key2 = "1234";
    private String text = "Encrypt me please";
    private String encrypted = "K4G5qzfoRJcqOZrPeu7QFZfkeBi5dPblIPaeXgqi0CYEkmURsAUGbJYkrEyU";
    private String plain = "I love being encrypted and decrypted, lucky me";

    @org.junit.jupiter.api.Test
    void encrypt() {
        String encryptedText = AesUtil.encrypt(text,key);
        String decrypted1 = AesUtil.decrypt(encryptedText,key);
        String decrypted2 = AesUtil.decrypt(encrypted,key);
        assertEquals(decrypted1,decrypted2);
    }

    @org.junit.jupiter.api.Test
    void decrypt() {
        String decrypted = AesUtil.decrypt(encrypted,key);
        assertEquals(text,decrypted);
    }

    @org.junit.jupiter.api.Test
    void generateKey() {
        String someKey = AesUtil.generateKey();
        assertNotNull(someKey);
    }

    @org.junit.jupiter.api.Test
    void encryptAndDecrypt() {
        String encryptedText = AesUtil.encrypt(plain,key);
        String decrypted = AesUtil.decrypt(encryptedText,key);
        assertEquals(decrypted,plain);
    }

    @org.junit.jupiter.api.Test
    void encryptAndDecryptDifferentValues() {
        String encrypted1 = AesUtil.encrypt(plain,key);
        String encrypted2 = AesUtil.encrypt(text,key);
        assertNotEquals(encrypted1,encrypted2);
    }

    @org.junit.jupiter.api.Test
    void sameTextDifferentKeys() {
        String encrypted1 = AesUtil.encrypt(plain,key);
        String encrypted2 = AesUtil.encrypt(plain,key2);
        assertNotEquals(encrypted1,encrypted2);
    }

}