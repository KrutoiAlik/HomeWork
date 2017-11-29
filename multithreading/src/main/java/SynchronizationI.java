import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SynchronizationI {


}

class XmlReaderToListTransactions extends Thread {

    static volatile int i = 0;
    NodeList xml;
    List<Transaction> transactions = new ArrayList<>();

    public XmlReaderToListTransactions(String s) throws IOException, SAXException, ParserConfigurationException {
        this.xml = getXml(s);
    }

    private static NodeList getXml(String s) throws ParserConfigurationException, IOException, SAXException {
        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(s);
        document.getDocumentElement().normalize();
        return document.getElementsByTagName(document.getDocumentElement().getChildNodes().item(1).getNodeName());
    }

    public void readXml() {
        synchronized (xml) {
            if (xml.item(i).getNodeType() == Node.ELEMENT_NODE)
                transactions.add(Transaction.getInstance((Element) xml.item(i)));
        }
    }

    List<Transaction> getTransactions() {
        return transactions;
    }
}
