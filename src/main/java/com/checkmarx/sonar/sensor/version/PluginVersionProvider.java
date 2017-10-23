package com.checkmarx.sonar.sensor.version;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by: zoharby.
 * Date: 22/10/2017.
 */
public class PluginVersionProvider {

    public String appendVersionToMsg(String message) {
        String version = getVersion();
        if("".equals(version)){
            return message;
        }
        return message  +" [Checkmarx plugin version: " + version +"]";
    }

    public String getVersion(){
        try {
            Properties properties = new Properties();
            InputStream is = getClass().getClassLoader().getResourceAsStream("project.properties");
            if (is != null) {
                properties.load(is);
                return properties.getProperty("version");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
