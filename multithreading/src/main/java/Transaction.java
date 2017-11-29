import org.w3c.dom.Element;

public class Transaction {

    String srcName;
    String dstName;
    String bill;


    public Transaction(String srcName, String dstName, String bill) {
        this.srcName = srcName;
        this.dstName = dstName;
        this.bill = bill;
    }

    static synchronized Transaction getInstance(Element element){
        return new Transaction(
                element.getElementsByTagName("src_name").item(0).getChildNodes().item(0).getNodeValue(),
                element.getElementsByTagName("dst_name").item(0).getChildNodes().item(0).getNodeValue(),
                element.getElementsByTagName("src_name").item(0).getChildNodes().item(0).getNodeValue());
    }

    public String getSrcName() {
        return srcName;
    }

    public String getDstName() {
        return dstName;
    }

    public String getBill() {
        return bill;
    }

    public void setSrcName(String srcName) {
        this.srcName = srcName;
    }

    public void setDstName(String dstName) {
        this.dstName = dstName;
    }

    public void setBill(String bill) {
        this.bill = bill;
    }

    public String toString() {
        return "Отправитель: " + srcName + "\r\n" +
                "Получатель: " + dstName + "\r\n" +
                "Счет: " + bill;
    }
}
