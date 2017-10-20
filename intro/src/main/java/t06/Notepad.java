package t06;

/**
 * @class класс Блокнот
 * Все записи хранятся в виде массива.
 *
 * @constructor {@link #Notepad(int)}
 * Создается массив для записей размером size
 *
 * @method {@link #printAll()}
 * Вывод всех записей блокнота.
 * В случае, если записи нет, отмечается "Пусто"
 *
 * @version 1.0
 *
 */
public class Notepad {

    String[] arrayNotes;

    public Notepad(int size) {
        this.arrayNotes = new String[size];
    }

    public void printAll() {
        System.out.println("Все записи");
        for (String s : arrayNotes) {
            if (s != null)
                System.out.println(s);
            else
                System.out.println("Пусто");
        }
    }

}

