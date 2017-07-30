package com.checkmarx.sonar.logger;

import org.sonar.api.utils.log.Logger;
import org.sonar.api.utils.log.Loggers;

/**
 * Created by: zoharby.
 * Date: 30/07/2017.
 */
public class CxLogger {

    private static String PREFIX = "- [CHECKMARX] - ";

    private Logger logger;

    public CxLogger(Class clazz) {
        this.logger = Loggers.get(clazz);
    }

    public void debug(String string){
        logger.debug(PREFIX + string);
    }

    public void info(String string){
        logger.info(PREFIX + string);
    }

    public void warn(String string){
        logger.warn(PREFIX + string);
    }

    public void error(String string){
        logger.error(PREFIX + string);
    }
}
