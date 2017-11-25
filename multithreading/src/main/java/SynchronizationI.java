import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SynchronizationI {

    static List<Transaction> transactions = new ArrayList<>();

    public static void main(String[] argv) throws Exception {

        NodeList nodeList = getInstance().getElementsByTagName(getInstance().getDocumentElement().getChildNodes().item(1).getNodeName());
        readTransaction(nodeList);
        for (Transaction t : transactions)
            System.out.println(t.toString() + "\r\n");
    }

    public static Document getInstance() throws ParserConfigurationException, IOException, SAXException {
        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse("multithreading/src/main/resources/transaction.xml");
        document.getDocumentElement().normalize();
        return document;
    }

    public static void readTransaction(NodeList nodeList){
        for (int i = 0; i < nodeList.getLength(); i++)
            if (nodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) nodeList.item(i);
                transactions.add(new Transaction(
                        element.getElementsByTagName("src_name").item(0).getChildNodes().item(0).getNodeValue(),
                        element.getElementsByTagName("dst_name").item(0).getChildNodes().item(0).getNodeValue(),
                        element.getElementsByTagName("src_name").item(0).getChildNodes().item(0).getNodeValue()));
            }
    }
}
