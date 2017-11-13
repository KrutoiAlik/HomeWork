package Serialization;

import java.io.*;

public class SerializationObject {

    static String s = "streams/src/main/java/Serialization/";

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        new SerializationObject().writeObject(CollectionFilms.getInstance(), s + "object.out");
        CollectionFilms collectionFilms = (CollectionFilms) new SerializationObject().readObject(s + "object.out");
        modify(collectionFilms);
        new SerializationObject().writeObject(collectionFilms, s + "objectii.out");
        System.out.println(collectionFilms);
    }

    static void modify(CollectionFilms collectionFilms) {
        collectionFilms.addPair(new Film("Начало"), new Actor("Леонардо Ди Каприони"));
    }

    public void writeObject(Object o, String file) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
            out.writeObject(o);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public Object readObject(String file) throws IOException, ClassNotFoundException {
        return new ObjectInputStream(new FileInputStream(file)).readObject();
    }
}
