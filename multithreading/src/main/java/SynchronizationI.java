import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SynchronizationI {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, InterruptedException {
        XmlReaderToListTransactions xml = new XmlReaderToListTransactions("multithreading/src/main/resources/transaction.xml");
        Thread t1 = new Thread(xml);
        Thread t2 = new Thread(xml);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(xml.getTransactions());
    }
}

class XmlReaderToListTransactions implements Runnable {

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

    @Override
    public void run() {
        for (i = 0; i < xml.getLength(); i++) readXml();
    }
}
