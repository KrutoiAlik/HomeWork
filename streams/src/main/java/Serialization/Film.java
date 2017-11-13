package Serialization;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.Set;
import java.util.TreeSet;

public class Film implements Serializable, Comparable {

    String name;
    Set<Actor> actors = new TreeSet<>();

    public Film(String name) {
        this.name = name;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!this.name.equals(((Film) obj).name))
            return false;
        if (!this.actors.containsAll(((Film) obj).actors))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return name + "\r\n" + actors.toString();
    }

    @Override
    public int compareTo(@NotNull Object o) {
        return this.name.compareTo(((Film) o).name);
    }
}
