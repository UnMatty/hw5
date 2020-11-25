package ru.matprojects.stc31.hw.hw5;

import java.util.UUID;

public class Animal {
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
}
