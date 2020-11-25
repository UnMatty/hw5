package ru.matprojects.stc31.hw.hw5;

public enum Sex {
    MALE("man"),
    FEMALE("woman");

    public String getTitle() {
        return title;
    }

    private String title;

    Sex(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Sex{" +
                "title='" + title + '\'' +
                '}';
    }
}
