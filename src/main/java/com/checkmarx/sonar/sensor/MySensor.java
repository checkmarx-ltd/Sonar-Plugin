package com.checkmarx.sonar.sensor;

import com.checkmarx.sonar.settings.CxProperties;
import org.sonar.api.Properties;
import org.sonar.api.Property;
import org.sonar.api.batch.sensor.Sensor;
import org.sonar.api.batch.sensor.SensorContext;
import org.sonar.api.batch.sensor.SensorDescriptor;

/**
 * Created by: zoharby.
 * Date: 27/04/2017.
 */
@Properties(
        {@Property(key = "setting.secured", name = "Secured", defaultValue = "42", project = true),
                @Property(key = "sonar.my.property.junk.secured", name = "My_Property", defaultValue = "My_val", project = true)
        })
public class MySensor implements Sensor{


        @Override
        public void describe(SensorDescriptor descriptor) {

        }

        @Override
        public void execute(SensorContext context) {
             String KKKK =   context.settings().getString(CxProperties.CXPROJECT_KEY);
        }
}
