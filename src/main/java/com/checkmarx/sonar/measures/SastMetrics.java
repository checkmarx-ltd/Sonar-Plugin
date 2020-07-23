package com.checkmarx.sonar.measures;

import org.sonar.api.measures.CoreMetrics;
import org.sonar.api.measures.Metric;
import org.sonar.api.measures.Metrics;

import java.util.List;

import static java.util.Arrays.asList;

/**
 * Created by: Zoharby.
 * Date: 23/05/2017.
 */
public class SastMetrics implements Metrics {

    public static String CX_SAST_DOMAIN = CoreMetrics.DOMAIN_SECURITY;

    public static String SAST_BASE_KEY = "cx.sast.result";
    public static String NON_COMMENTIOG_LINES_OF_CODE = "Non commenting lines of code";

    public static final Metric<Integer> SAST_HIGH_VULNERABILITIES = new Metric.Builder(SAST_BASE_KEY+".high", "Checkmarx - 1. High Vulnerabilities", Metric.ValueType.INT)
            .setDescription(NON_COMMENTIOG_LINES_OF_CODE)
            .setDirection(Metric.DIRECTION_WORST)
            .setQualitative(false)
            .setDomain(CX_SAST_DOMAIN)
            .create();

    public static final Metric<Integer> SAST_MEDIUM_VULNERABILITIES = new Metric.Builder(SAST_BASE_KEY+".medium", "Checkmarx - 2. Medium Vulnerabilities", Metric.ValueType.INT)
            .setDescription(NON_COMMENTIOG_LINES_OF_CODE)
            .setDirection(Metric.DIRECTION_WORST)
            .setQualitative(false)
            .setDomain(CX_SAST_DOMAIN)
            .create();

    public static final Metric<Integer> SAST_LOW_VULNERABILITIES = new Metric.Builder(SAST_BASE_KEY +".low", "Checkmarx - 3. Low Vulnerabilities", Metric.ValueType.INT)
            .setDescription(NON_COMMENTIOG_LINES_OF_CODE)
            .setDirection(Metric.DIRECTION_WORST)
            .setQualitative(false)
            .setDomain(CX_SAST_DOMAIN)
            .create();



    public static final Metric<Integer> SAST_TOTAL_VULNERABILITIES = new Metric.Builder(SAST_BASE_KEY +".total", "Checkmarx - 4. Total Vulnerabilities", Metric.ValueType.INT)
            .setDescription(NON_COMMENTIOG_LINES_OF_CODE)
            .setDirection(Metric.DIRECTION_WORST)
            .setQualitative(false)
            .setDomain(CX_SAST_DOMAIN)
            .create();

    public static final Metric<Integer> SAST_NEW_HIGH_VULNERABILITIES = new Metric.Builder(SAST_BASE_KEY+"new.high", "Checkmarx - 5. New High Vulnerabilities", Metric.ValueType.INT)
            .setDescription(NON_COMMENTIOG_LINES_OF_CODE)
            .setDirection(Metric.DIRECTION_WORST)
            .setQualitative(false)
            .setDomain(CX_SAST_DOMAIN)
            .create();

    public static final Metric<Integer> SAST_NEW_MEDIUM_VULNERABILITIES = new Metric.Builder(SAST_BASE_KEY+"new.medium", "Checkmarx - 6. New Medium Vulnerabilities", Metric.ValueType.INT)
            .setDescription(NON_COMMENTIOG_LINES_OF_CODE)
            .setDirection(Metric.DIRECTION_WORST)
            .setQualitative(false)
            .setDomain(CX_SAST_DOMAIN)
            .create();

    public static final Metric<Integer> SAST_NEW_LOW_VULNERABILITIES = new Metric.Builder(SAST_BASE_KEY +"new.low", "Checkmarx - 7. New Low Vulnerabilities", Metric.ValueType.INT)
            .setDescription(NON_COMMENTIOG_LINES_OF_CODE)
            .setDirection(Metric.DIRECTION_WORST)
            .setQualitative(false)
            .setDomain(CX_SAST_DOMAIN)
            .create();

    public static final Metric<Integer> SAST_TOTAL_NEW_VULNERABILITIES = new Metric.Builder(SAST_BASE_KEY +".new.total", "Checkmarx - 8. Total New Vulnerabilities", Metric.ValueType.INT)
            .setDescription(NON_COMMENTIOG_LINES_OF_CODE)
            .setDirection(Metric.DIRECTION_WORST)
            .setQualitative(false)
            .setDomain(CX_SAST_DOMAIN)
            .create();

    public static final Metric<Integer> SONAR_PROJECT_HAVE_SAST_RESULTS = new Metric.Builder(SAST_BASE_KEY +".have_results", "Sonar project have sast results", Metric.ValueType.INT)
            .setDescription("Sonar project have sast results")
            .setQualitative(false)
            .setHidden(true)
            .setDomain(CX_SAST_DOMAIN)
            .create();


    public static final Metric<String> SAST_SCAN_DETAILS = new Metric.Builder(SAST_BASE_KEY +".details", "Checkmarx sast scan details", Metric.ValueType.STRING)
            .setDescription("Additional scan details")
            .setQualitative(true)
            .setHidden(true)
            .setDomain(CX_SAST_DOMAIN)
            .create();

    public static final Metric<String> SAST_SCAN_QUERIES = new Metric.Builder(SAST_BASE_KEY +".queries", "Checkmarx queries that are presented in sonar.", Metric.ValueType.STRING)
            .setDescription("Checkmarx queries that are presented as issues in sonar.")
            .setQualitative(true)
            .setHidden(true)
            .setDomain(CX_SAST_DOMAIN)
            .create();



    @Override
    public List<Metric> getMetrics() {
        return asList(SAST_HIGH_VULNERABILITIES, SAST_MEDIUM_VULNERABILITIES, SAST_LOW_VULNERABILITIES, SAST_TOTAL_VULNERABILITIES,
                SAST_NEW_HIGH_VULNERABILITIES, SAST_NEW_MEDIUM_VULNERABILITIES, SAST_NEW_LOW_VULNERABILITIES, SAST_TOTAL_NEW_VULNERABILITIES,
                SONAR_PROJECT_HAVE_SAST_RESULTS, SAST_SCAN_DETAILS, SAST_SCAN_QUERIES);
    }
}
