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
                .setInputMetrics(SAST_HIGH_VULNERABILITIES.key(), SAST_MEDIUM_VULNERABILITIES.key(), SAST_LOW_VULNERABILITIES.key(),SAST_TOTAL_VULNERABILITIES.key(),
                        SAST_NEW_HIGH_VULNERABILITIES.key(), SAST_NEW_MEDIUM_VULNERABILITIES.key(), SAST_NEW_LOW_VULNERABILITIES.key(), SAST_TOTAL_NEW_VULNERABILITIES.key(), SAST_SCAN_DETAILS.key())
                .setOutputMetrics(SAST_HIGH_VULNERABILITIES.key(), SAST_MEDIUM_VULNERABILITIES.key(), SAST_LOW_VULNERABILITIES.key(),SAST_TOTAL_VULNERABILITIES.key(),
                        SAST_NEW_HIGH_VULNERABILITIES.key(), SAST_NEW_MEDIUM_VULNERABILITIES.key(), SAST_NEW_LOW_VULNERABILITIES.key(), SAST_TOTAL_NEW_VULNERABILITIES.key(), SAST_SCAN_DETAILS.key())
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
            int sumNewHigh = 0;
            int sumNewMedium = 0;
            int sumNewLow = 0;


            //todo one method to rule them all

            for (Measure child : context.getChildrenMeasures(SAST_HIGH_VULNERABILITIES.key())) {
                sumHigh += child.getIntValue();
            }

            for (Measure child : context.getChildrenMeasures(SAST_MEDIUM_VULNERABILITIES.key())) {
                sumMedium += child.getIntValue();
            }

            for (Measure child : context.getChildrenMeasures(SAST_LOW_VULNERABILITIES.key())) {
                sumLow += child.getIntValue();
            }


            for (Measure child : context.getChildrenMeasures(SAST_NEW_HIGH_VULNERABILITIES.key())) {
                sumNewHigh += child.getIntValue();
            }

            for (Measure child : context.getChildrenMeasures(SAST_NEW_MEDIUM_VULNERABILITIES.key())) {
                sumNewMedium += child.getIntValue();
            }

            for (Measure child : context.getChildrenMeasures(SAST_NEW_LOW_VULNERABILITIES.key())) {
                sumNewLow += child.getIntValue();
            }


            context.addMeasure(SAST_HIGH_VULNERABILITIES.key(), sumHigh);
            context.addMeasure(SAST_MEDIUM_VULNERABILITIES.key(), sumMedium);
            context.addMeasure(SAST_LOW_VULNERABILITIES.key(), sumLow);
            context.addMeasure(SAST_TOTAL_VULNERABILITIES.key(), sumHigh + sumMedium + sumLow);
            context.addMeasure(SAST_NEW_HIGH_VULNERABILITIES.key(), sumNewHigh);
            context.addMeasure(SAST_NEW_MEDIUM_VULNERABILITIES.key(), sumNewMedium);
            context.addMeasure(SAST_NEW_LOW_VULNERABILITIES.key(), sumNewLow);
            context.addMeasure(SAST_TOTAL_NEW_VULNERABILITIES.key(), sumNewHigh + sumNewMedium + sumNewLow);
        }

    }


}

