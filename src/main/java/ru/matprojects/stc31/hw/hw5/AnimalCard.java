package ru.matprojects.stc31.hw.hw5;

import java.util.*;
import java.util.stream.Collectors;

public class AnimalCard {
    private SortedMap<String, List<Animal>> animalNameMap;
    private Map<UUID, Animal> animalUuidMap;
    AnimalCard(){
        animalNameMap = new TreeMap<>();
        animalUuidMap = new HashMap<>();
    }

    public void addAnimal(Animal animal){
        if (animalUuidMap.get(animal.getUnicNumber()) != null)
            throw new AnimalAddException("Animal with num " + animal.getUnicNumber() + " already exists");

        animalUuidMap.put(animal.getUnicNumber(), animal);
        List<Animal> animals = animalNameMap.get(animal.getName());
        if (animals == null) {
            animals = new ArrayList<>();
        }
        animals.add(animal);
        animalNameMap.put(animal.getName(), animals);
    }

    public Animal getAnimalById(UUID id) {
        return animalUuidMap.getOrDefault(id, null);
    }

    public List<Animal> getAnimalByName(String name) {
        return animalNameMap.getOrDefault(name, null);
    }

    public void clear() {
        animalNameMap.clear();
        animalUuidMap.clear();
    }

    public void printSortedAnimalList(){
        Collection<Animal> values = animalUuidMap.values();
        List<Animal> collect = values.stream().sorted().collect(Collectors.toUnmodifiableList());
        for (Animal animal : collect) {
            System.out.println(animal);
        }
    }
}
