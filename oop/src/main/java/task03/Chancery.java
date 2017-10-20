package task03;

public abstract class Chancery {

    public int price;

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public int compareTo(Chancery chancery){
        if(this.price > chancery.price)
            return 1;
        else if (this.price < chancery.price)
            return -1;
        else
            return 0;
    }

    public int compareBy2Args(Chancery chancery){
        int cmp = this.getClass().getSimpleName().compareTo(chancery.getClass().getSimpleName());
        if(cmp != 0)
            return cmp;
        else
            return this.compareTo(chancery);
    }
}
