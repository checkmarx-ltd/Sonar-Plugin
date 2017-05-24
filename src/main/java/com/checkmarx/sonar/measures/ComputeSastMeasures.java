package com.checkmarx.sonar.measures;

import org.sonar.api.ce.measure.Component;
import org.sonar.api.ce.measure.Measure;
import org.sonar.api.ce.measure.MeasureComputer;

import static com.checkmarx.sonar.measures.SastMetrics.*;

/**
 * Created by: Zoharby.
 * Date: 23/05/2017.
 */
public class ComputeSastMeasures implements MeasureComputer {


    @Override
    public MeasureComputerDefinition define(MeasureComputerDefinitionContext def) {
        return def.newDefinitionBuilder()
                .setInputMetrics()
                .setInputMetrics(SAST_HIGH_VULNERABILITIES.key(), SAST_MEDIUM_VULNERABILITIES.key(), SAST_LOW_VULNERABILITIES.key())
                .setOutputMetrics(SAST_TOTAL_VULNERABILITIES.key(), SAST_HIGH_VULNERABILITIES.key(), SAST_MEDIUM_VULNERABILITIES.key(), SAST_LOW_VULNERABILITIES.key())
                .build();
    }

    @Override
    public void compute(MeasureComputerContext context) {
        // measure is already defined on files by {@link SetSizeOnFilesSensor}
        // in scanner stack
        if (context.getComponent().getType() != Component.Type.FILE) {
            int sumHigh = 0;
            int sumMedium = 0;
            int sumLow = 0;
            int sumTotal = 0;

            for (Measure child : context.getChildrenMeasures(SAST_HIGH_VULNERABILITIES.key())) {
                sumHigh += child.getIntValue();
            }

            for (Measure child : context.getChildrenMeasures(SAST_MEDIUM_VULNERABILITIES.key())) {
                sumMedium += child.getIntValue();
            }

            for (Measure child : context.getChildrenMeasures(SAST_LOW_VULNERABILITIES.key())) {
                sumLow += child.getIntValue();
            }

            for (Measure child : context.getChildrenMeasures(SAST_TOTAL_VULNERABILITIES.key())) {
                sumTotal += child.getIntValue();
            }

            context.addMeasure(SAST_HIGH_VULNERABILITIES.key(), sumHigh);
            context.addMeasure(SAST_MEDIUM_VULNERABILITIES.key(), sumMedium);
            context.addMeasure(SAST_LOW_VULNERABILITIES.key(), sumLow);
            context.addMeasure(SAST_TOTAL_VULNERABILITIES.key(), sumTotal);
        }

    }
}

