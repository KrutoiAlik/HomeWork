package Serialization;

import lombok.SneakyThrows;

import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;

public class CollectionFilms implements Serializable {

    Map<Film, Actor> collection = new TreeMap<>();

    static CollectionFilms getInstance(){
        CollectionFilms collectionFilms = new CollectionFilms();
        collectionFilms.collection.put(new Film("Film"), new Actor("Actor"));
        return collectionFilms;
    }

    static CollectionFilms getInstance(Map<Film, Actor> collection){
        CollectionFilms collectionFilms = new CollectionFilms();
        collectionFilms.collection.putAll(collection);
        return collectionFilms;
    }

    void addPair(Film film, Actor actor){
        this.collection.put(film, actor);
    }

    void removeFilm(Film film){
        this.collection.remove(film);
    }

    @Override
    public String toString() {
        return collection.toString();
    }
}
