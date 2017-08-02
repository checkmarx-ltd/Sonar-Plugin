package com.checkmarx.sonar.measures;

import org.sonar.api.ce.measure.Component;
import org.sonar.api.ce.measure.Measure;
import org.sonar.api.ce.measure.MeasureComputer;
import org.sonar.api.measures.Metric;

import static com.checkmarx.sonar.measures.SastMetrics.*;

/**
 * Created by: Zoharby.
 * Date: 23/05/2017.
 */
public class ComputeSastMeasures implements MeasureComputer {

    @Override
    public MeasureComputerDefinition define(MeasureComputerDefinitionContext def) {
        return def.newDefinitionBuilder()
                .setInputMetrics(SONAR_PROJECT_HAVE_SAST_RESULTS.key(), SAST_HIGH_VULNERABILITIES.key(), SAST_MEDIUM_VULNERABILITIES.key(), SAST_LOW_VULNERABILITIES.key(),SAST_TOTAL_VULNERABILITIES.key(),
                        SAST_NEW_HIGH_VULNERABILITIES.key(), SAST_NEW_MEDIUM_VULNERABILITIES.key(), SAST_NEW_LOW_VULNERABILITIES.key(), SAST_TOTAL_NEW_VULNERABILITIES.key(), SAST_SCAN_DETAILS.key())
                .setOutputMetrics(SONAR_PROJECT_HAVE_SAST_RESULTS.key(), SAST_HIGH_VULNERABILITIES.key(), SAST_MEDIUM_VULNERABILITIES.key(), SAST_LOW_VULNERABILITIES.key(),SAST_TOTAL_VULNERABILITIES.key(),
                        SAST_NEW_HIGH_VULNERABILITIES.key(), SAST_NEW_MEDIUM_VULNERABILITIES.key(), SAST_NEW_LOW_VULNERABILITIES.key(), SAST_TOTAL_NEW_VULNERABILITIES.key(), SAST_SCAN_DETAILS.key())
                .build();
    }

    @Override
    public void compute(MeasureComputerContext context) {
        if (context.getComponent().getType() != Component.Type.FILE) {
            if(isResult(context)){
                int sumHigh = sumMetric(SAST_HIGH_VULNERABILITIES, context);
                int sumMedium = sumMetric(SAST_MEDIUM_VULNERABILITIES, context);
                int sumLow = sumMetric(SAST_LOW_VULNERABILITIES, context);
                int sumNewHigh = sumMetric(SAST_NEW_HIGH_VULNERABILITIES, context);
                int sumNewMedium = sumMetric(SAST_NEW_MEDIUM_VULNERABILITIES, context);
                int sumNewLow = sumMetric(SAST_NEW_LOW_VULNERABILITIES, context);

                //compute fails without adding this measure
                context.addMeasure(SONAR_PROJECT_HAVE_SAST_RESULTS.key(), sumMetric(SONAR_PROJECT_HAVE_SAST_RESULTS, context));

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

    private boolean isResult(MeasureComputerContext context){
        for (Measure child : context.getChildrenMeasures(SONAR_PROJECT_HAVE_SAST_RESULTS.key())) {
            if(child.getIntValue() > 0){
                return true;
            }
        }
        return false;
    }
    private int sumMetric(Metric<Integer> integerMetric, MeasureComputerContext context){
        int toRet = 0;
        for (Measure child : context.getChildrenMeasures(integerMetric.key())) {
            toRet += child.getIntValue();
        }
        return toRet;
    }

}

