package com.checkmarx.sonar.sensor.execution;

import com.checkmarx.sonar.sensor.dto.CxReportToSonarReport;
import com.checkmarx.sonar.sensor.dto.CxResultToSonarResult;

import java.util.HashMap;
import java.util.List;

/**
 * Created by: zoharby.
 * Date: 06/08/2017.
 */
class CxSonarFilePathUtil {

    static List<CxResultToSonarResult> findResultsByFilePath(CxReportToSonarReport cxReport, String sonarFilePath){
        //adjust for cx path pattern
        String formattedSonarFilePath = toCxFilePathFormat(sonarFilePath);
        List<CxResultToSonarResult> toRet = cxReport.getResultsMappedByFileDir().get(formattedSonarFilePath);

        //in a case where sonar and cx wrote the file directories from different starting point
        if(toRet == null)
            for (HashMap.Entry<String, List<CxResultToSonarResult>> entry : cxReport.getResultsMappedByFileDir().entrySet()) {
                String cxFilePath = entry.getKey();
                if(formattedSonarFilePath.length() == cxFilePath.length()){
                    //if the paths were identical the path would have been retrieved from map (toRet would not be null)
                    continue;
                }
                if (isUnequalLengthPathsRepresentsTheSamePath(formattedSonarFilePath, cxFilePath)) {
                    toRet = entry.getValue();
                    break;
                }
            }
        return toRet;
    }

   static boolean isCxPathAndSonarPathTheSame(String cxFilePath, String sonarFilePath){
        //adjust for cx path pattern
        String formattedSonarFilePath = toCxFilePathFormat(sonarFilePath);

        if (sonarFilePath.equals(cxFilePath)) {
            return true;
        }else if(cxFilePath.length() == formattedSonarFilePath.length()){
            //if path are not equals() and have the same length they do not represent the same path
            return false;
        } else if (isUnequalLengthPathsRepresentsTheSamePath(formattedSonarFilePath, cxFilePath)) {
            return true;
        }
        return false;
    }

    private static String toCxFilePathFormat(String sonarFilePath){
        return sonarFilePath.replace("\\", "/");
    }

    //for unequal paths only
    private static boolean isUnequalLengthPathsRepresentsTheSamePath(String pathA, String pathB){
        String longPath;
        String shortPath;

        if(pathA.length() > pathB.length()){
            return false;
        }
        if(pathA.length() > pathB.length()){
            longPath = pathA;
            shortPath = pathB;
        }else {
            longPath = pathB;
            shortPath = pathA;
        }
        String endOfLongPath = longPath.substring(longPath.length() - shortPath.length() , longPath.length());
        return endOfLongPath.equals(shortPath);
    }

}
