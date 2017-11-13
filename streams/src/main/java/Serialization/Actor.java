package Serialization;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.Set;
import java.util.TreeSet;

public class Actor implements Serializable, Comparable{
    String name;
    Set<Film> films = new TreeSet<>();

    public Actor(String name) {
        this.name = name;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!this.name.equals(((Film) obj).name))
            return false;
        if (!this.films.containsAll(((Film) obj).actors))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return name + "\r\n" + films.toString();
    }

    @Override
    public int compareTo(@NotNull Object o) {
        return this.name.compareTo(((Film) o).name);
    }
}
