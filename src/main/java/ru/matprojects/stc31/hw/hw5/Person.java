package ru.matprojects.stc31.hw.hw5;

public class Person implements Comparable<Person>{
    private String name;
    private int age;
    private Sex sex;

    public Person(String name, int age, Sex sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    @Override
    public int compareTo(Person o) {
        if (o.sex.equals(this.sex)) {
            if (o.age == this.age) {
                return o.name.compareTo(this.name);
            } else if (o.age > this.age)
                return -1;
            else
                return 1;
        } else if (this.sex.equals(Sex.MALE))
            return 1;
        else
            return -1;
    }

    @Override
    public String toString() {
        return "name = " + name +
                "; age = " + age +
                "; sex=" + sex;
    }
}
