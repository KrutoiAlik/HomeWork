public class Transaction {

    String srcName;
    String dstName;
    String bill;


    public Transaction(String srcName, String dstName, String bill) {
        this.srcName = srcName;
        this.dstName = dstName;
        this.bill = bill;
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
