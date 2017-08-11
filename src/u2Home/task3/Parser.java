package u2Home.task3;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class Parser {
    public static void main(String[] args) {
        try {
            String inputFile = "C:\\Users\\I\\Documents\\yql.xml";
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            XPath xPath =  XPathFactory.newInstance().newXPath();

            String expression = "//results/rate";
            NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(doc, XPathConstants.NODESET);
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node nNode = nodeList.item(i);
//                System.out.println("\nВалюта :"
//                        + nNode.getNodeName());
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    System.out.println("id : "
                            + eElement.getAttribute("id"));
                    System.out.println("Name : "
                            + eElement
                            .getElementsByTagName("Name")
                            .item(0)
                            .getTextContent());
                    System.out.println("Rate : "
                            + eElement
                            .getElementsByTagName("Rate")
                            .item(0)
                            .getTextContent());
                    System.out.println("Date : "
                            + eElement
                            .getElementsByTagName("Date")
                            .item(0)
                            .getTextContent());
                    System.out.println("Time : "
                            + eElement
                            .getElementsByTagName("Time")
                            .item(0)
                            .getTextContent());
                    System.out.println("Ask : "
                            + eElement
                            .getElementsByTagName("Ask")
                            .item(0)
                            .getTextContent());
                    System.out.println("Bid : "
                            + eElement
                            .getElementsByTagName("Bid")
                            .item(0)
                            .getTextContent()
                            + "\n=========");

                }
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
    }
}
