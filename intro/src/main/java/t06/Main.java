package t06;

import java.util.Scanner;

/**
 *  @task06 Спроектировать и разработать классы "Запись в блокнот" и "Блокнот"
 *  @author Alexey Bezmoshchuk
 *
 *  @param {@link package.home01.javase01.t06{@link #notepad} - экземпляр объекта Блокнот
 *  @param {@link package.home01.javase01.t06{@link #writeInNotePad} - экземпляр объекта Запись в блокнот
 *
 *  @method {@link #initObjects()} - создание объектов
 *  @method {@link #addNote()} - добавление записей в блокнот
 *  @method {@link #deleteNote()} - удаление записей с определенным номером из блокнота
 *  @method {@link #editNote()} - редактирование записи с определенным номером в блокноте
 *
 *  @class {@link Notepad} - реализация Блокнота
 *  @class {@link WriteInNotePad} - реализация объекта Запись в блокнот
 *  Хранит реализации методов для работы с блокнотом
 *
 *  @version 1.0
 */

public class Main{

    static Notepad notepad;
    static WriteInNotePad writeInNotePad;

    public static void main(String[] args) throws InterruptedException {
        initObjects();
        addNote();
        deleteNote();
        editNote();
    }

    static void initObjects(){
        System.out.print("Размер блокнота: ");
        notepad = new Notepad(new Scanner(System.in).nextInt());
        writeInNotePad = new WriteInNotePad(notepad);
    }

    static void addNote(){
        writeInNotePad.addNote("First String");
        notepad.printAll();
    }

    static void deleteNote(){
        writeInNotePad.editNote(1,"Second String");
        notepad.printAll();
    }

    static void editNote(){
        writeInNotePad.deleteNote(1);
        notepad.printAll();
    }
}
