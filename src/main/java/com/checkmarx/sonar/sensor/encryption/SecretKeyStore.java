package com.checkmarx.sonar.sensor.encryption;

import javax.crypto.SecretKey;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableEntryException;
import java.security.cert.CertificateException;

/**
 * Represents a file-based storage for a single secret key.
 */
public class SecretKeyStore {
    private static final String KEY_ALIAS = "CxCredentials";

    // This type allows storing keys for symmetric encryption.
    private static final String KEY_STORE_TYPE = "JCEKS";

    private static final char[] PASSWORD = "RksdGtdBvkJmetJ-ieQX95FtN8Ozac".toCharArray();

    private static final int KEY_SIZE = 128;

    private static final String KEYSTORE_FILENAME = "keystore.bin";

    /**
     * Loads the secret key from the key store file.
     */
    public SecretKey getSecretKey() throws IOException {
        SecretKey result;
        try {
            KeyStore keyStore = KeyStore.getInstance(KEY_STORE_TYPE);
            try (InputStream storeFile = getClass().getClassLoader().getResourceAsStream(KEYSTORE_FILENAME)) {
                keyStore.load(storeFile, PASSWORD);
            }
            KeyStore.SecretKeyEntry entry = (KeyStore.SecretKeyEntry) keyStore.getEntry(KEY_ALIAS, getProtection());

            result = entry.getSecretKey();

        } catch (KeyStoreException | IOException | NoSuchAlgorithmException | CertificateException | UnrecoverableEntryException e) {
            throw new IOException("Error getting secret key.", e);
        }
        return result;
    }

    /**
     * Creates a secret key and stores it in a new file-based KeyStore.
     * @param passphrase secret text, base for key generation
     * @param salt hex string of length 64
     * @param iterationCount number on the order of thousands
     * @param targetDir directory where the keystore file to be created
     */
    private void createKeyStoreFile(String passphrase, String salt, int iterationCount, String targetDir) throws IOException {
        try {
            KeyStore keyStore = KeyStore.getInstance(KEY_STORE_TYPE);
            keyStore.load(null, null);

            AesUtil encryptor = new AesUtil();
            SecretKey key = encryptor.generateKey(passphrase, salt, iterationCount, KEY_SIZE);

            KeyStore.SecretKeyEntry entry = new KeyStore.SecretKeyEntry(key);

            keyStore.setEntry(KEY_ALIAS, entry, getProtection());

            File fileToCreate = new File(targetDir, KEYSTORE_FILENAME);
            try (FileOutputStream output = new FileOutputStream(fileToCreate)) {
                keyStore.store(output, PASSWORD);
            }
        } catch (KeyStoreException | IOException | NoSuchAlgorithmException | CertificateException e) {
            throw new IOException("Error creating KeyStore.", e);
        }
    }

    /**
     * Call this method for one-time generation of a secret key stored in a keystore file.
     * The command line can look like this:<br>
     * {@code
     *  mvn exec:java -Dexec.mainClass="com.checkmarx.sonar.sensor.encryption.SecretKeyStore" -Dexec.args="mypassphrase AAABBBCCC22342FEAAABBBCCC22342FEAAABBBCCC22342FEAAABBBCCC22342FE 2000 c:\temp"
     * }
     */
    public static void main(String[] args) throws IOException {
        final int EXPECTED_ARGS_LENGTH = 4;
        if (args.length < EXPECTED_ARGS_LENGTH) {
            throw new IllegalArgumentException(String.format("%d arguments expected.", EXPECTED_ARGS_LENGTH));
        }

        SecretKeyStore store = new SecretKeyStore();
        store.createKeyStoreFile(args[0], args[1], Integer.parseInt(args[2]), args[3]);
    }

    private KeyStore.PasswordProtection getProtection() {
        return new KeyStore.PasswordProtection(PASSWORD);
    }
}
