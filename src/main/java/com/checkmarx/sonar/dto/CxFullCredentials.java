package com.checkmarx.sonar.dto;

import com.checkmarx.sonar.sensor.encryption.AesUtil;
import com.checkmarx.sonar.settings.CxProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.sonar.api.batch.sensor.SensorContext;

import java.io.IOException;

/**
 * Created by: zoharby.
 * Date: 24/04/2017.
 */
public class CxFullCredentials {

    @JsonProperty("cxServerUrl")
    private String cxServerUrl;
    @JsonProperty("cxUsername")
    private String cxUsername;
    @JsonProperty("cxPassword")
    private String cxPassword;

    private static final String IV = "F27D5C9927726BCEFE7510B1BDD3D137";
    private static final String SALT = "3FF2EC019C627B945225DEBAD71A01B6985FE84C95A70EB132882F88C0A59A55";
    private static final int KEY_SIZE = 128;
    private static final int ITERATION_COUNT = 10000;
    private static final String PASSPHRASE = "checkmarx.server.credentials.secured";





    public CxFullCredentials() {
    }

    public CxFullCredentials(String cxServerUrl, String cxUser, String password) {
        this.cxServerUrl = cxServerUrl;
        this.cxUsername = cxUser;
        this.cxPassword = password;

    }

    public void setCxServerUrl(String cxServerUrl) {
        this.cxServerUrl = cxServerUrl;
    }

    public String getCxServerUrl() {
        return cxServerUrl;
    }

    public void setCxUsername(String cxUsername) {
        this.cxUsername = cxUsername;
    }

    public String getCxUsername() {
        return cxUsername;
    }

    public void setCxPassword(String cxPassword) {
        this.cxPassword = cxPassword;
    }

    public String getCxPassword() {
        return cxPassword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CxFullCredentials)) return false;

        CxFullCredentials that = (CxFullCredentials) o;

        if (!getCxServerUrl().equals(that.getCxServerUrl())) return false;
        if (!getCxUsername().equals(that.getCxUsername())) return false;
        return getCxPassword().equals(that.getCxPassword());

    }

    @Override
    public int hashCode() {
        int result = getCxServerUrl().hashCode();
        result = 31 * result + getCxUsername().hashCode();
        result = 31 * result + getCxPassword().hashCode();
        return result;
    }

    public static CxFullCredentials getCxFullCredentials(String credentialsJson) throws IOException {

        AesUtil util = new AesUtil(KEY_SIZE, ITERATION_COUNT);
        credentialsJson = util.decrypt(SALT, IV, PASSPHRASE, credentialsJson);

        CxFullCredentials cxFullCredentials = transformKeepSpecialCharacters(credentialsJson);

        return cxFullCredentials;
    }

    private static CxFullCredentials transformKeepSpecialCharacters(String credentialsJson) throws IOException {
        CxFullCredentials cxFullCredentials;
        ObjectMapper mapper = new ObjectMapper();

        String passwordOrig = new String(credentialsJson.substring(credentialsJson.lastIndexOf(": \"")+3,credentialsJson.lastIndexOf("\"")));
        credentialsJson = credentialsJson.replace(passwordOrig,"aaa");

        String temp = credentialsJson.substring(credentialsJson.indexOf("cxUsername") + 13);
        String usernameOrig = temp.substring(1,temp.indexOf("\","));
        String usernameTemp = "aaa";
        credentialsJson = credentialsJson.replace(usernameOrig,usernameTemp);
        cxFullCredentials = mapper.readValue(credentialsJson, CxFullCredentials.class);
        cxFullCredentials.setCxPassword(passwordOrig);
        cxFullCredentials.setCxUsername(usernameOrig);
        return cxFullCredentials;
    }

    public static CxFullCredentials getCxFullCredentials(SensorContext context) throws IOException {
        String cxCredentialsJson = context.settings().getString(CxProperties.CX_CREDENTIALS_KEY);
        return getCxFullCredentials(cxCredentialsJson);
    }

}