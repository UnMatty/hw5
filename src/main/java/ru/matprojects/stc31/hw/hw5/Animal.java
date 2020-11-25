package ru.matprojects.stc31.hw.hw5;

import java.util.UUID;

public class Animal implements Comparable<Animal> {
    private UUID unicNumber;
    private String name;
    private Person owner;
    private double weight;

    public Animal(UUID unicNumber, String name, Person owner, double weight) {
        this.unicNumber = unicNumber;
        this.name = name;
        this.owner = owner;
        this.weight = weight;
    }

    public UUID getUnicNumber() {
        return unicNumber;
    }

    public String getName() {
        return name;
    }

    public Person getOwner() {
        return owner;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public int hashCode() {
        return this.unicNumber.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;

        if (!obj.getClass().equals(this.getClass()))
            return false;

        Animal c = (Animal) obj;
        if (c.unicNumber.equals(this.unicNumber))
            return true;

        return false;
    }

    @Override
    public int compareTo(Animal o) {
        if (o.equals(this))
            return 0;

        int c = o.owner.compareTo(this.owner);
        if (c == 0) {
            c = o.name.compareTo(this.name);
            if (c == 0) {
                if (o.weight > this.weight)
                    return 1;
                else if (o.weight == this.weight)
                    return 0;
                else
                    return -1;
            } else
                return c;
        } else
            return c;
    }

    @Override
    public String toString() {
        if (this.owner == null || this.unicNumber == null)
            return "";
        else
            return "Owner = (" + this.owner.toString() +
                    "); id = " + this.unicNumber.toString() +
                    "; name = " + this.name +
                    "; weight = " + this.weight;
    }
}
