package com.checkmarx.sonar.sensor.execution;

import com.checkmarx.sonar.cxportalservice.sast.model.CxXMLResults;
import org.sonar.api.batch.fs.InputFile;

/**
 * Created by: zoharby.
 * Date: 06/08/2017.
 */
class CodeHighlightsUtil {

    static Highlight getHighlightForPathNode(InputFile file, CxXMLResults.Query.Result.Path.PathNode pathNode){
        try {
            if(pathNode.getLine() > file.lines()){
                return new Highlight(1, -1, -1);
            }

            String codeSnippet;
            try {
                codeSnippet = pathNode.getSnippet().getLine().getCode();
            }catch (Exception e){
                if(pathNode.getLine() > 0) {
                    if(pathNode.getColumn() > 0 && pathNode.getLength() > 0){
                        return new Highlight(pathNode.getLine(), pathNode.getColumn() - 1, pathNode.getColumn() + pathNode.getLength() - 1);
                    }
                    return new Highlight(pathNode.getLine(), -1, -1);
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
        try{
            String selectedText = codeSnippet.substring(pathNode.getColumn() - 1, pathNode.getColumn() + pathNode.getLength() - 1);
            if ((pathNode.getLine()) > 0 && (pathNode.getName() != null) && (!pathNode.getName().equals("")) && (selectedText.indexOf(pathNode.getName(), 0) == -1) &&
                    (codeSnippet.indexOf(pathNode.getName(), 0) > -1) && (selectedText.indexOf("this", 0) == -1)) {
                if (codeSnippet.indexOf(pathNode.getName(), pathNode.getColumn()) == -1) {
                    int start = codeSnippet.indexOf(pathNode.getName(), 0);
                    return new Highlight(pathNode.getLine(), start, start + pathNode.getName().length());
                } else {
                    return new Highlight(pathNode.getLine(), codeSnippet.indexOf(pathNode.getName(), pathNode.getColumn()), codeSnippet.indexOf(pathNode.getName(), pathNode.getColumn()) + pathNode.getName().length());
                }
            } else {
                if (pathNode.getLength() == 0) {
                    return new Highlight(pathNode.getLine(), -1, -1);
                }
                return new Highlight(pathNode.getLine(), pathNode.getColumn() - 1, pathNode.getColumn() + pathNode.getLength() - 1);
            }
        }catch (StringIndexOutOfBoundsException e0){
            return new Highlight(pathNode.getLine(), -1, -1);
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
