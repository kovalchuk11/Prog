package u2Home.task1;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.*;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SeachXML {
    public static void main(String[] args) {
        String fileName = "C:\\Users\\I\\Documents\\progKiev\\Prog\\src\\u2Home\\task1\\Trains.xml";
        try {
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = documentBuilder.parse(fileName);

            try {
                printCost(document);
            } catch (ParseException e) {
                e.printStackTrace();
            }

        } catch (XPathExpressionException | ParserConfigurationException | SAXException | IOException ex) {
            ex.printStackTrace(System.out);
        }
    }

    public static void printCost(Document document) throws DOMException, XPathExpressionException, ParseException {
        Date time = null;
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        XPathFactory pathFactory = XPathFactory.newInstance();
        XPath xPath = pathFactory.newXPath();
        XPathExpression xPathExpression = xPath.compile("trains/train[date = '19.12.2017']");
        NodeList nodes = (NodeList) xPathExpression.evaluate(document, XPathConstants.NODESET);
        System.out.println("с 15:00 до 19:00");
        for (int i = 0; i < nodes.getLength(); i++) {
            Node n = nodes.item(i);
            Element element = (Element) n;
            time = sdf.parse(element.getElementsByTagName("departure").item(0).getTextContent());
            if (time.after(sdf.parse("15:00")) & time.before(sdf.parse("19:00"))) {
                String cg = nodes.item(i).getTextContent();
                System.out.println(cg);
            }
        }
    }
}