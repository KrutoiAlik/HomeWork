package t01.main;

import t01.logic.Logic;

/**
 * @task01 Запуск через командную строку
 * <p>
 * Необходимо находиться в папке src/main/java, т.к. home01 общий пакет, где объект Main может увидеть объект Logic
 * В обратном случае, объект Main не сможет скомпилироваться из-за отсутствия объекта Logic
 * <p>
 * javac home01/javase01/t01/main/Main.java - компиляция, создание классов Main и Logic
 * java home01/javase01/t01/main/Main - запуск класса Main
 */

public class Main {
    public static void main(String[] args) {
        Logic logic = new Logic();
        System.out.println(logic.method());
    }
}
