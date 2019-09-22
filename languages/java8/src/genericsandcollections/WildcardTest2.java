package genericsandcollections;

/**
 * @author razib
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Testing bounded wildcard
 */

public class WildcardTest2 {

    public static void main(String[] args) {
        List<?> anyList = new ArrayList<String>();
        anyList.clear();
        anyList.remove("o");
        anyList.size();
        anyList.add(null);
        //anyList.add("not possible");

        List<? extends Animal> catList1 = new ArrayList<Cat>();
        catList1.add(new Cat("cat33")); //not compile; don't know it's a list of cat (List<Cat>)
        Cat c1 = catList1.get(0); //not compile 'required Cat - found Animal'
        Animal c2 = catList1.get(0); //compile

        List<? super Animal> catList2 = new ArrayList<Animal>();
        catList2.add(new Cat("cat34")); //compile
        Cat c3 = catList2.get(0); //not compile
        Animal c4 = catList2.get(0); //not compile
    }
}
