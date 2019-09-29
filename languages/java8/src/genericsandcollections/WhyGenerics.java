package genericsandcollections;

import java.util.ArrayList;
import java.util.List;

class Apple {

    String color;
    float weight;

    public Apple(String color, float weight) {
        this.color = color;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "color='" + color + '\'' +
                ", weight=" + weight +
                '}';
    }
}

class Bird{ }

public class WhyGenerics {

    public static void main(String[] args) {

        //List without generics
        List box = new ArrayList();
        box.add(new Apple("green", 150));
        box.add(new Apple("green", 149));
        box.add(new Apple("red", 130));
        box.add(new Bird());

        //NOTE: without generics we need explicit casting here
        //Which is error prone
        Apple apple1 = (Apple) box.get(0);
        System.out.println(apple1);

        //the below line give a runtime 'java.lang.ClassCastException'
        //Apple appleX = (Apple)box.get(3);

        //but if we declare List like
        List<Apple> anotherBox = new ArrayList<>();
        anotherBox.add(new Apple("green", 147));
        anotherBox.add(new Apple("green", 142));

        //now we can get apple without any explicit casting
        Apple apple2 = anotherBox.get(0);
        System.out.println(apple2);
        //which is less erro rprone
        //moreover with generics we can define a custom data type of any type. Like here with help of generics we have
        //declared 'list of Apple' (List<Apple>) generics help us defining programming for border. Cause now we can use
        //the same list for different data types.


    }
}
