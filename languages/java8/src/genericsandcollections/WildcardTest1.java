package genericsandcollections;

import java.util.ArrayList;
import java.util.List;

/**
 * @author razib
 * Testing Unbound (<?>) wildcard
 */

class Animal {
    String name;

    Animal() {
        System.out.println("Animal's default constructor");
    }

    Animal(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}

class Cat extends Animal {

    Cat(String name) {
        this.name = name;
    }
}

class Dog extends Animal {

    Dog(String name) {
        this.name = name;
    }
}

//Unbound<?> wild card testing
public class WildcardTest1 {

    public static void main(String[] args) {

        Dog[] dogsArray = new Dog[10];
        Animal[] animalsArray = dogsArray; //compile; could produce error at tuntime
        animalsArray[0] = new Dog("dog0");
        animalsArray[1] = new Cat("cat0"); //throws ArrayStoreException at runtime

        List<Animal> animals = new ArrayList<>();
        List<Cat> cats = new ArrayList<>();
        List<Dog> dogs = new ArrayList<>();
        List<String> strings = new ArrayList<>();

        animals.add(new Animal("animal1"));

        cats.add(new Cat("cat1"));
        cats.add(new Cat("cat2"));
        cats.add(new Cat("cat3"));

        dogs.add(new Dog("dog1"));
        dogs.add(new Dog("dog2"));

        strings.add("string1");
        strings.add("string2");
        strings.add("string3");
        strings.add("string4");

        printAnyList(animals);
        printAnyList(cats);
        printAnyList(dogs);
        printAnyList(strings);

        //printObjects(animals);
        //printAnimals(animals);



    }

    public static void printObjects(List<Object> objects) {
        for (Object each : objects) {
            System.out.printf("%s ", each);
        }
        System.out.println();
    }

    public static void printAnimals(List<Animal> animals) {
        for (Animal each : animals) {
            System.out.printf("%s ", each);
        }
        System.out.println();
    }

    public static void printCats(List<Cat> cats) {
        for (Cat each : cats) {
            System.out.printf("%s ", each);
        }
        System.out.println();
    }

    public static void printDogs(List<Dog> dogs) {
        for (Dog each : dogs) {
            System.out.printf("%s ", each);
        }
        System.out.println();
    }

    public static void printAnyList(List<?> genericList) {
        for (Object each : genericList) {
            System.out.printf("%s ", each);
        }
        System.out.println();
    }
}
