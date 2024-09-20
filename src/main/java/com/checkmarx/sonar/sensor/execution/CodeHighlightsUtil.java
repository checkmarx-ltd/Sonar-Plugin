package com.checkmarx.sonar.sensor.execution;

import com.cx.restclient.sast.dto.CxXMLResults;
import org.apache.commons.lang.StringUtils;
//import org.sonar.api.batch.fs.InputFile;
import org.sonar.api.*;
import org.sonar.api.batch.fs.InputFile;
/**
 * Created by: zoharby.
 * Date: 06/08/2017.
 */
class CodeHighlightsUtil {

    static Highlight getHighlightForPathNode(InputFile file, CxXMLResults.Query.Result.Path.PathNode pathNode){
        int line = !StringUtils.isEmpty(pathNode.getLine()) ? Integer.valueOf(pathNode.getLine()):0;
        int column = !StringUtils.isEmpty(pathNode.getColumn()) ? Integer.valueOf(pathNode.getColumn()):0;
        int length = !StringUtils.isEmpty(pathNode.getLength()) ? Integer.valueOf(pathNode.getLength()):0;
        try {
            if(line > file.lines()){
                return new Highlight(1, -1, -1);
            }

            String codeSnippet;
            try {
                codeSnippet = pathNode.getSnippet().getLine().getCode();
            }catch (Exception e){
                if(line > 0) {
                    if(column > 0 && length > 0){
                        return new Highlight(line, column - 1, column + length - 1);
                    }
                    return new Highlight(line, -1, -1);
                }
                return null;
            }

            return createHighlightUsingCodeSnippet(pathNode, codeSnippet);
        }catch (Exception e){
             e.printStackTrace();
        }
        return null;
    }

    private static Highlight createHighlightUsingCodeSnippet(CxXMLResults.Query.Result.Path.PathNode pathNode, String codeSnippet){
        int line = !StringUtils.isEmpty(pathNode.getLine()) ? Integer.valueOf(pathNode.getLine()):0;
        int column = !StringUtils.isEmpty(pathNode.getColumn()) ? Integer.valueOf(pathNode.getColumn()):0;
        int length = !StringUtils.isEmpty(pathNode.getLength()) ? Integer.valueOf(pathNode.getLength()):0;
        try{
            String selectedText = codeSnippet.substring(column - 1,column + length - 1);
            if ((line) > 0 && (pathNode.getName() != null) && (!pathNode.getName().equals("")) && (selectedText.indexOf(pathNode.getName(), 0) == -1) &&
                    (codeSnippet.indexOf(pathNode.getName(), 0) > -1) && (selectedText.indexOf("this", 0) == -1)) {
                if (codeSnippet.indexOf(pathNode.getName(), column) == -1) {
                    int start = codeSnippet.indexOf(pathNode.getName(), 0);
                    return new Highlight(line, start, start + pathNode.getName().length());
                } else {
                    return new Highlight(line, codeSnippet.indexOf(pathNode.getName(), column), codeSnippet.indexOf(pathNode.getName(), column) + pathNode.getName().length());
                }
            } else {
                if (length == 0) {
                    return new Highlight(line, -1, -1);
                }
                return new Highlight(line, column - 1, column + length - 1);
            }
        }catch (StringIndexOutOfBoundsException e0){
            return new Highlight(line, -1, -1);
        } catch (Exception e1){
            return null;
        }
    }

    static class Highlight{

        private int line;
        private int start;
        private int end;

        Highlight(int line, int start, int end) {
            this.line = line;
            this.start = start;
            this.end = end;
        }

        public int getLine() {
            return line;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

        @Override
        public String toString() {
            return "Highlight{" +
                    "line=" + line +
                    ", start=" + start +
                    ", end=" + end +
                    '}';
        }
    }
}
