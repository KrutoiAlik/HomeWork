package home02.javase01.task03;

import org.junit.jupiter.api.Test;
import task01.Pen;
import task03.Chancery;
import task03.NewbiePackage;
import task03.Pencil;

class NewbiePackageTest {

    NewbiePackage<Chancery> pack = new NewbiePackage<>();
    Pen p1 = new Pen("YELLOW", "plast", false);
    Pen p2 = new Pen("CYAN", "plast", false);
    Pen p3 = new Pen("WHITE", "plast", false);

    @Test
    void add() {
        pack.add(p1);
    }

    @Test
    void set() {
        pack.add(p1);
        pack.set(p1, p2);
    }

    @Test
    void sortByName(){
        pack.add(p1);
        pack.add(p2);
        pack.add(p3);
        Pencil pncl = new Pencil();
        pncl.price = 100;
        pack.add(pncl);

    }
    @Test
    void delete() {
        pack.add(p2);
        pack.delete(p2);
    }

    @Test
    void isContains() {
        pack.add(p1);
        pack.isContains(p2);
    }

    @Test
    void getPriceOfAll() {
        pack.getPriceOfAll();
    }

}