package com.checkmarx.sonar.measures;

import org.sonar.api.measures.Metric;
import org.sonar.api.measures.Metrics;

import java.util.List;

import static java.util.Arrays.asList;

/**
 * Created by: Zoharby.
 * Date: 24/05/2017.
 */
public class OsaMetrics implements Metrics {

    public static String CX_OSA_DOMAIN = "Checkmarx OSA Security";

    public static String OSA_BASE_KEY = "cx.osa.result";

    public static final Metric<Integer> OSA_HIGH_VULNERABILITIES = new Metric.Builder(OSA_BASE_KEY +".high", "High Vulnerabilities", Metric.ValueType.INT)
            .setDescription("Non commenting lines of code")
            .setDirection(Metric.DIRECTION_WORST)
            .setQualitative(false)
            .setDomain(CX_OSA_DOMAIN)
            .create();

    public static final Metric<Integer> OSA_MEDIUM_VULNERABILITIES = new Metric.Builder(OSA_BASE_KEY +".medium", "Medium Vulnerabilities", Metric.ValueType.INT)
            .setDescription("Non commenting lines of code")
            .setDirection(Metric.DIRECTION_WORST)
            .setQualitative(false)
            .setDomain(CX_OSA_DOMAIN)
            .create();

    public static final Metric<Integer> OSA_LOW_VULNERABILITIES = new Metric.Builder(OSA_BASE_KEY +".low", "Low Vulnerabilities", Metric.ValueType.INT)
            .setDescription("Non commenting lines of code")
            .setDirection(Metric.DIRECTION_WORST)
            .setQualitative(false)
            .setDomain(CX_OSA_DOMAIN)
            .create();



    public static final Metric<Integer> OSA_TOTAL_VULNERABILITIES = new Metric.Builder(OSA_BASE_KEY +".total", "Total Vulnerabilities", Metric.ValueType.INT)
            .setDescription("Non commenting lines of code")
            .setDirection(Metric.DIRECTION_WORST)
            .setQualitative(false)
            .setDomain(CX_OSA_DOMAIN)
            .create();


    public static final Metric<String> OSA_SCAN_DETAILS = new Metric.Builder(OSA_BASE_KEY +".details", "Checkmarx OSA scan details", Metric.ValueType.STRING)
            .setDescription("Additional scan details")
            .setQualitative(true)
            .setHidden(true)
            .setDomain(CX_OSA_DOMAIN)
            .create();



    @Override
    public List<Metric> getMetrics() {
        return asList(OSA_HIGH_VULNERABILITIES, OSA_MEDIUM_VULNERABILITIES, OSA_LOW_VULNERABILITIES, OSA_TOTAL_VULNERABILITIES, OSA_SCAN_DETAILS);
    }
}
