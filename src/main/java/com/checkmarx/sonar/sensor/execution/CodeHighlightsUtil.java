package com.checkmarx.sonar.sensor.execution;

import com.checkmarx.sonar.cxportalservice.sast.model.CxXMLResults;

/**
 * Created by: zoharby.
 * Date: 06/08/2017.
 */
public class CodeHighlightsUtil {

    static Highlight getHighlightForPathNode(CxXMLResults.Query.Result.Path.PathNode pathNode){
        try {
            String lineText = pathNode.getSnippet().getLine().getCode();
            String selectedText = lineText.substring(pathNode.getColumn() - 1, pathNode.getColumn() + pathNode.getLength() - 1);

            if ((pathNode.getLine()) > 0 && (pathNode.getName() != null) && (!pathNode.getName().equals("")) && (selectedText.indexOf(pathNode.getName(), 0) == -1) &&
                    (lineText.indexOf(pathNode.getName(), 0) > -1) && (selectedText.indexOf("this", 0) == -1)) {
                if(lineText.indexOf(pathNode.getName(), pathNode.getColumn()) == -1) {
                    int start = lineText.indexOf(pathNode.getName(), 0);
                    return new Highlight(pathNode.getLine(), start, start + pathNode.getName().length());
                }else {
                    return new Highlight(pathNode.getLine(), lineText.indexOf(pathNode.getName(), pathNode.getColumn()), lineText.indexOf(pathNode.getName(), pathNode.getColumn()) + pathNode.getName().length());
                }
            } else {
                return new Highlight(pathNode.getLine(), pathNode.getColumn() - 1, pathNode.getColumn() + pathNode.getLength() - 1);
            }
        }catch (Exception e){
            //todo logging
        }
        return null;
    }

    static class Highlight{

        private int line;
        private int start;
        private int end;

        public Highlight(int line, int start, int end) {
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
    }

}
