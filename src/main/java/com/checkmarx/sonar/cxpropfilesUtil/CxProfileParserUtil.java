package com.checkmarx.sonar.cxpropfilesUtil;

import java.io.InputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class CxProfileParserUtil {

    public static CxProfileData parseProfile(InputStream inputStream) throws Exception {
        // Initialize DocumentBuilder with desired settings
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setIgnoringComments(true);
        factory.setIgnoringElementContentWhitespace(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(inputStream);
        document.getDocumentElement().normalize();

        // Extract profile name and language; throw an exception if missing
        String profileName = getTagValue(document, "name");
        String language = getTagValue(document, "language");

        if (profileName == null || profileName.isEmpty() ||
            language == null || language.isEmpty()) {
            throw new Exception("Mandatory fields missing in Profile: <name> or <language>.");
        }

        CxProfileData profileData = new CxProfileData(profileName, language);

        // Extract rules
        NodeList ruleNodes = document.getElementsByTagName("rule");
        for (int i = 0; i < ruleNodes.getLength(); i++) {
            Element ruleElement = (Element) ruleNodes.item(i);
            String repositoryKey = getTagValue(ruleElement, "repositoryKey");
            String ruleKey = getTagValue(ruleElement, "key");
            // Optionally, extract priority and parameters if defined.
            CxRuleData ruleData = new CxRuleData(repositoryKey, ruleKey);
            profileData.addRule(ruleData);
        }
        return profileData;
    }

    private static String getTagValue(Document document, String tagName) {
        NodeList nodeList = document.getElementsByTagName(tagName);
        return (nodeList.getLength() > 0) ? nodeList.item(0).getTextContent().trim() : null;
    }

    private static String getTagValue(Element element, String tagName) {
        NodeList nodeList = element.getElementsByTagName(tagName);
        return (nodeList.getLength() > 0) ? nodeList.item(0).getTextContent().trim() : null;
    }
}