package com.checkmarx.sonar.measures;

import org.sonar.api.batch.fs.FileSystem;
import org.sonar.api.batch.fs.InputFile;
import org.sonar.api.batch.sensor.Sensor;
import org.sonar.api.batch.sensor.SensorContext;
import org.sonar.api.batch.sensor.SensorDescriptor;
import org.sonar.api.measures.Metric;

import static com.checkmarx.sonar.measures.OsaMetrics.*;

/**
 * Created by: Zoharby.
 * Date: 24/05/2017.
 */
public class OsaSensor implements Sensor {

    @Override
    public void describe(SensorDescriptor descriptor) {

    }

    @Override
    public void execute(SensorContext context) {

        FileSystem fs = context.fileSystem();
        // only "main" files, but not "tests"
        Iterable<InputFile> files = fs.inputFiles(fs.predicates().hasType(InputFile.Type.MAIN));
        //get osa results
        //save in settings

        for (InputFile file : files) {
            addMetric(context, file, OSA_HIGH_VULNERABILITIES, 5);
            addMetric(context, file, OSA_MEDIUM_VULNERABILITIES, 4);
            addMetric(context, file, OSA_LOW_VULNERABILITIES, 0);
            addMetric(context, file, OSA_TOTAL_VULNERABILITIES, 5+4+3);
        }
    }

    private void addMetric(final SensorContext context, final InputFile inputFile, final Metric<Integer> metric, int value) {
        context.<Integer> newMeasure().forMetric(metric).on(inputFile).withValue(value).save();
    }
}
