package com.checkmarx.sonar.sensor.execution;

import com.checkmarx.sonar.sensor.dto.CxReportToSonarReport;
import com.checkmarx.sonar.sensor.dto.CxResultToSonarResult;

import java.util.HashMap;
import java.util.List;

/**
 * Created by: zoharby.
 * Date: 06/08/2017.
 */
public class CxSonarFilePathUtil {

    static List<CxResultToSonarResult> findResultsByFilePath(CxReportToSonarReport cxReport, String sonarFilePath){
        //adjust for cx path pattern
        String formattedSonarFilePath = sonarFilePath.replace("\\", "/");
        List<CxResultToSonarResult> toRet = cxReport.getResultsMappedByFileDir().get(formattedSonarFilePath);

        //in a case where sonar and cx wrote the file directories from different starting point
        if(toRet == null)
            for (HashMap.Entry<String, List<CxResultToSonarResult>> entry : cxReport.getResultsMappedByFileDir().entrySet()) {
                String cxFilePath = entry.getKey();

                if (formattedSonarFilePath.contains(cxFilePath) || cxFilePath.contains(formattedSonarFilePath)) {
                    toRet = entry.getValue();
                    break;
                }
            }
        return toRet;
    }

   static boolean isCxPathAndSonarPathEquals(String cxFilePath, String sonarFilePath){
        //adjust for cx path pattern
        String formattedSonarFilePath = sonarFilePath.replace("\\", "/");

        if (sonarFilePath.equals(cxFilePath)) {
            return true;
        } else if (formattedSonarFilePath.contains(cxFilePath) || cxFilePath.contains(formattedSonarFilePath)) {
            return true;
        }
        return false;
    }


}
