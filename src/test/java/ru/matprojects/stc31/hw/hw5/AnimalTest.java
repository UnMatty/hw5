package ru.matprojects.stc31.hw.hw5;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class AnimalTest {
    private AnimalCard animalCard;

    private Person genNewPerson(){
        int w = new Random().nextInt(100);
        return new Person("SomeRandomName" + w, w, w % 2 == 1 ? Sex.MALE : Sex.FEMALE);
    }

    private Animal genNewAnimal(Person person) {
        int w = new Random().nextInt(36);
        return new Animal(UUID.randomUUID(), "RandomAnName" + w, person, w);
    }

    private Animal genTestAnimal() {
        return new Animal(UUID.randomUUID(),
                "TestName",
                new Person("PersonName", 12, Sex.FEMALE),
                123);
    }

    @BeforeEach
    void setUp() {
        animalCard = new AnimalCard();
        Person person = null;
        for (int i = 0; i < 1000; i++){
            if (person == null || i % 10 == 0)
                person = genNewPerson();

            Animal animal = genNewAnimal(person);
            animalCard.addAnimal(animal);
        }
    }

    @AfterEach
    void tearDown() {
        animalCard.clear();
    }

    @Test
    void AnimalCreationTestOk() {
        Animal animal = genTestAnimal();
        animalCard.addAnimal(animal);
    }

    @Test
    void AnimalCreationTestFailed() {
        Animal animal = genTestAnimal();
        animalCard.addAnimal(animal);
        assertThrows(AnimalAddException.class, () -> animalCard.addAnimal(animal));
    }

    @Test
    void AnimalSearchByNameTest() {
        Animal animal = genTestAnimal();
        animalCard.addAnimal(animal);
        List<Animal> animalByName = animalCard.getAnimalByName(animal.getName());
        assertEquals(1, animalByName.size());
        assertEquals(animalByName.get(0), animal);
    }

    @Test
    void AnimalSearchById() {
        Animal animal = genTestAnimal();
        animalCard.addAnimal(animal);
        Animal animalById = animalCard.getAnimalById(animal.getUnicNumber());
        assertNotNull(animalById);
        assertEquals(animal, animalById);
    }

    @Test
    void printTest() {
        animalCard.printSortedAnimalList();
    }
}