package com.checkmarx.sonar.settings;

import com.checkmarx.sonar.dto.CxFullCredentials;
import com.checkmarx.sonar.sensor.encryption.AesUtil;
import com.checkmarx.sonar.sensor.encryption.SecretKeyStore;
import com.checkmarx.sonar.sensor.utils.CxConfigHelper;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;

import javax.crypto.SecretKey;
import java.io.IOException;

public class CredentialMigration {

    private static final String LEGACY_CREDENTIALS_KEY = "checkmarx.server.credentials.secured";

    private static final String IV = "F27D5C9927726BCEFE7510B1BDD3D137";

    private final ObjectMapper objectMapper = new ObjectMapper();

    private final Logger logger;

    private PropertyApiClient client;

    public CredentialMigration(PropertyApiClient client, Logger logger) {
        this.client = client;
        this.logger = logger;
    }

    /**
     * Checks if credentials are stored in old format in a Sonar property. If they are, converts the credentials to a
     * new format.
     * The old format is: encrypt(json(serverUrl,username,password))
     * The new format is: json(serverUrl, username, encrypt(password))
     * The change in format was needed to avoid storing crypto keys on the client.
     *
     * @throws IOException
     */
    public void ensureLatestFormat() throws IOException {
        String encryptedLegacyCredentials = null;
        try {
            encryptedLegacyCredentials = client.getProperty(LEGACY_CREDENTIALS_KEY);
        } catch (Exception e) {
            logger.debug("No sonar authentication was given.");
        }
        if (StringUtils.isNotEmpty(encryptedLegacyCredentials)) {
            logger.info("Found credentials in legacy format. Starting the migration.");

            SecretKeyStore keyStore = new SecretKeyStore();
            SecretKey key = keyStore.getSecretKey();

            AesUtil util = new AesUtil();
            String legacyCredentials = util.decrypt(key, IV, encryptedLegacyCredentials);

            JsonNode root = objectMapper.readTree(legacyCredentials);

            CxFullCredentials credentialsToSave = new CxFullCredentials();
            credentialsToSave.setCxServerUrl(root.get("cxServerUrl").textValue());
            credentialsToSave.setCxUsername(root.get("cxUsername").textValue());

            String plainPassword = root.get("cxPassword").textValue();
            String encryptedPassword = CxConfigHelper.encrypt(plainPassword);
            credentialsToSave.setCxPassword(encryptedPassword);

            String credentialsJson = objectMapper.writeValueAsString(credentialsToSave);
            client.setProperty(CxProperties.CREDENTIALS_KEY, credentialsJson);

            client.deleteProperty(LEGACY_CREDENTIALS_KEY);

            logger.info("Migration completed successfully.");
        }
    }
}
