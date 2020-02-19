package com.checkmarx.sonar.sensor.execution;

import com.checkmarx.sonar.logger.CxLogger;
import com.checkmarx.sonar.sensor.dto.CxResultToSonarResult;
import com.cx.restclient.sast.dto.CxXMLResults;
import org.sonar.api.batch.fs.InputFile;
import org.sonar.api.batch.sensor.issue.NewIssueLocation;
import org.sonar.api.batch.sensor.issue.internal.DefaultIssueLocation;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by: zoharby.
 * Date: 23/08/2017.
 *
 * creates Issue locations that will be presented in sonar UI on the presented project code
 */
class FileIssueLocationsCreator {

    private CxLogger logger = new CxLogger(FileIssueLocationsCreator.class);

    private InputFile file;

    FileIssueLocationsCreator(InputFile file) {
        this.file = file;
    }

    List<NewIssueLocation> createFlowLocations(CxResultToSonarResult result){
        List<NewIssueLocation> allLocationsInFile = new LinkedList<>();

        try {
            DefaultIssueLocation firstLocationInFile = null;
            List<CxXMLResults.Query.Result.Path.PathNode> resultsNodes = result.getResultData().getPath().getPathNode();

            //locations iteration will be from end to start because sonar inserts the list in that order
            int nodeLoopEndIdx = 0;
            int nodeLoopStartIdx = resultsNodes.size() - 1;

            //if the first node in result is not within the scanned file
            if (!CxSonarFilePathUtil.isCxPathAndSonarPathTheSame(resultsNodes.get(0).getFileName(), file.absolutePath())) {
                logger.debug("Creating highlight for the first location in file:");
                //a message stating the location of the first node
                String msg = " ; Origin - file: " + resultsNodes.get(0).getFileName() + " line: " + resultsNodes.get(0).getLine();
                //find the first node that do appear in the file, create location for it, and add to it the above message
                for (CxXMLResults.Query.Result.Path.PathNode node : result.getResultData().getPath().getPathNode()) {
                    if (CxSonarFilePathUtil.isCxPathAndSonarPathTheSame(node.getFileName(), file.absolutePath())) {
                        firstLocationInFile = createLocationFromPathNode(node);
                        if (firstLocationInFile == null) {
                            continue;
                        }
                        //set index to the node that comes after the first location
                        nodeLoopEndIdx = resultsNodes.indexOf(node) + 1;

                        if (!CxSonarFilePathUtil.isCxPathAndSonarPathTheSame(resultsNodes.get(nodeLoopEndIdx).getFileName(), file.absolutePath())) {
                            msg = msg + " ; Next location: " + resultsNodes.get(nodeLoopEndIdx).getName() + " ; file: " +
                                    resultsNodes.get(nodeLoopEndIdx).getFileName() + " line: " + resultsNodes.get(nodeLoopEndIdx).getLine();
                            ++nodeLoopEndIdx;
                        }
                        firstLocationInFile.message(node.getName() + msg);
                        break;
                    }
                }
            }

            logger.debug("Creating highlight for locations:");
            //set isPrevInFile as true to stay within legal index in resultsNodes
            boolean isPrevNodeInFile = true;
            boolean isCurrNodeInFile = CxSonarFilePathUtil.isCxPathAndSonarPathTheSame(resultsNodes.get(nodeLoopStartIdx).getFileName(), file.absolutePath());
            boolean isNextNodeInFile;
            //iteration from end to start because sonar inserts the list in that order
            for (int i = nodeLoopStartIdx; i >= nodeLoopEndIdx; --i) {
                //set isNextNodeInFile as true in last node to stay within legal index in resultsNodes
                isNextNodeInFile = i <= 0 || CxSonarFilePathUtil.isCxPathAndSonarPathTheSame(resultsNodes.get(i - 1).getFileName(), file.absolutePath());
                CxXMLResults.Query.Result.Path.PathNode currNode = resultsNodes.get(i);
                if (isCurrNodeInFile) {
                    DefaultIssueLocation defaultIssueLocation = createLocationFromPathNode(currNode);
                    if (defaultIssueLocation == null) {
                        isCurrNodeInFile = isNextNodeInFile;
                        continue;
                    }
                    //next and prev in messages are to be opposites to next and prev in loop booleans(because iteration is end to start)
                    String msgPrev = isNextNodeInFile ? "" : " ; Previous location: " + resultsNodes.get(i - 1).getName() + " ; file: " +
                            resultsNodes.get(i - 1).getFileName() + " line: " + resultsNodes.get(i - 1).getLine();
                    String msgNext = isPrevNodeInFile ? "" : " ; Next location: " + resultsNodes.get(i + 1).getName() + " ; file: " +
                            resultsNodes.get(i + 1).getFileName() + " line: " + resultsNodes.get(i + 1).getLine();
                    String msg = currNode.getName() + msgPrev + msgNext;
                    allLocationsInFile.add(defaultIssueLocation.message(msg));

                    isPrevNodeInFile = true;
                } else {
                    isPrevNodeInFile = false;
                }
                isCurrNodeInFile = isNextNodeInFile;
            }

            if (firstLocationInFile != null) {
                allLocationsInFile.add(firstLocationInFile);
            }

        }catch (Exception e){
            logger.warn("Could not highlight locations for vulnerability: "+ result.getQuery().getName() + " on file: "+file.absolutePath());
            logger.warn("due to exception: " + e.getMessage());
        }

        return allLocationsInFile;
    }

    DefaultIssueLocation createIssueLocation(CxResultToSonarResult result){
        CodeHighlightsUtil.Highlight highlightLine = CodeHighlightsUtil.getHighlightForPathNode(file, result.getNodeToMarkOnFile());
        if(highlightLine == null){
            highlightLine = new CodeHighlightsUtil.Highlight(1, -1, -1);
        }
        DefaultIssueLocation defaultIssueLocation = new DefaultIssueLocation();

        return defaultIssueLocation.on(file)
                .at(file.selectLine(highlightLine.getLine()))
                .message("Checkmarx Vulnerability : " + result.getQuery().getName());
    }

    private DefaultIssueLocation createLocationFromPathNode(CxXMLResults.Query.Result.Path.PathNode node){
        CodeHighlightsUtil.Highlight highlight = CodeHighlightsUtil.getHighlightForPathNode(file, node);
        if(highlight == null){
            return null;
        }
        logger.debug("File "+ file.absolutePath() +", "+ highlight.toString());
        DefaultIssueLocation defaultIssueLocation = new DefaultIssueLocation();

        if(highlight.getStart() == -1){
            if(highlight.getLine() <= 1){
                return defaultIssueLocation.on(file);
            }
            return defaultIssueLocation.on(file)
                    .at(file.selectLine(highlight.getLine()));
        }
        return defaultIssueLocation.on(file)
                .at(file.newRange(file.newPointer(highlight.getLine(), highlight.getStart()),
                        file.newPointer(highlight.getLine(), highlight.getEnd())));
    }

}
