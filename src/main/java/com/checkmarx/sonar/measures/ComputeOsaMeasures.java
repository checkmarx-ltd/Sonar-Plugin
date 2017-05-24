package com.checkmarx.sonar.measures;

import org.sonar.api.ce.measure.Component;
import org.sonar.api.ce.measure.Measure;
import org.sonar.api.ce.measure.MeasureComputer;
import org.sonar.api.measures.Metric;

import static com.checkmarx.sonar.measures.OsaMetrics.*;

/**
 * Created by: Zoharby.
 * Date: 24/05/2017.
 */
public class ComputeOsaMeasures implements MeasureComputer {


    @Override
    public MeasureComputerDefinition define(MeasureComputerDefinitionContext def) {
        return def.newDefinitionBuilder()
                .setInputMetrics(OSA_TOTAL_VULNERABILITIES.key(), OSA_HIGH_VULNERABILITIES.key(), OSA_MEDIUM_VULNERABILITIES.key(), OSA_LOW_VULNERABILITIES.key())
                .setOutputMetrics(OSA_TOTAL_VULNERABILITIES.key(), OSA_HIGH_VULNERABILITIES.key(), OSA_MEDIUM_VULNERABILITIES.key(), OSA_LOW_VULNERABILITIES.key())
                .build();
    }

    @Override
    public void compute(MeasureComputerContext context) {
        if (context.getComponent().getType() != Component.Type.FILE) {

            int highMetric = getMetricsValue(context, OSA_HIGH_VULNERABILITIES);

            //If one vulnerability level have a value, all levels have a value
            if( highMetric> -1) {
                context.addMeasure(OSA_HIGH_VULNERABILITIES.key(), highMetric);
                context.addMeasure(OSA_MEDIUM_VULNERABILITIES.key(), getMetricsValue(context, OSA_MEDIUM_VULNERABILITIES));
                context.addMeasure(OSA_LOW_VULNERABILITIES.key(), getMetricsValue(context, OSA_LOW_VULNERABILITIES));
                context.addMeasure(OSA_TOTAL_VULNERABILITIES.key(), getMetricsValue(context, OSA_TOTAL_VULNERABILITIES));
            }
        }
    }

    private int getMetricsValue(MeasureComputerContext context, Metric<Integer> metric){
        int ret = -1;//-1 is a flag that means there is no metric
        for (Measure child : context.getChildrenMeasures(metric.key())) {
            ret = child.getIntValue();
            break; //All metric values are identical for osa, no need to iterate
        }
        return ret;
    }

}

