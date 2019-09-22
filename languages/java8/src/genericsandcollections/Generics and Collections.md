# <u>Generic and Collections</u>

## <u>Why Generics / The Motivation for Generics</u>

- consider the following 2 code snippet where generics are not used

  ```java
  //without generics
  class Apple{}
  class Bird{}
  ...
  List box1 = new ArrayList();//1
  box1.add(new Apple());
  box1.add(new Bird()) //2
  Apple a1 = (Apple) box1.get(0); //explicit type casting
  Apple a2 = (Apple) box1.get(1); //3
  ```

  ```java
  //with generics
  class Apple{}
  class Bird{}
  ...
  List<Apple> box2 = new ArrayList<>(); //4
  box2.add(new Apple()); //5
  box2.add(new Bird()); //6
  ```

  

  - [1] -  if you are not using generics then you can put anything(`Object`) at the `ArrayList` 
  - [2] - note we are putting now `Bird` here at `box1` though first line we put `Apple` there. 
  - [3] - actually its' an `Bird` at index 1, not an `Apple`. But I may not know what is there in the `box1` 's index position 1. In that case casting it to `Apple` will give us `java.lang.ClassCastException` at runtime, though both 2 and 3  compile fine.
  - [4,5,6] - now we have create the `box2` using generic. And the `box2` is meant for storing only `Apple`. Going further, when we put anything but `Apple`  at `box2` we will get a compilation error.  

- Notice the following code snippet  

  ```java
  Integer[] integerArray = new Integer[10];
  Double[] doubleArray = new Double[11];
  Character[] characterArray = new Character[12];
  ....
  //if we want to print the Array we can use the following 3 different methods
  public void printIntegerArray(Integer[] array){}
  public void printLongArray(Long[] array){}
  public void printCharacterArray(Character[] array){}
  ```

  -  but if we use generic then we can use only a single method to print all of the list - ***generics enables types to be parameters***

  ```java
  //using generic the all 3 methods could be wrie in a single method 
  public <E> void printArray(E[] array) {
       for(E element : array){
            System.out.printf("%s ", element);
       }
  }
  
  //calling the above generic method - 'printArray'
  Integer[] integerArray = { 1, 2, 3, 4, 5, 6 };
  Double[] doubleArray = { 1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7 };
  Character[] characterArray = { 'H', 'E', 'L', 'L', 'O' };
  printArray(integerArray);
  printArray(doubleArray);
  printArray(characterArray);
  ```

  - we are here passing type as parameter 

- **In a nutshell,**

  - generics enable ***types (classes and interfaces) to be parameters*** when defining classes, interfaces and methods. 

    - Much like the more familiar ***formal parameters*** used in method declarations, **type parameters** provide a way for you to re-use the same code with different inputs. 
      - The difference is that the inputs to ***formal parameters*** are values, while the inputs to ***type parameters*** are types.

    

## <u>Advantage of Generics</u>

- Based on the [above discussion](#why-generics--the-motivation-for-generics) 
  - Generics give us a way to  ***compile time type checking*** and to avoid ***runtime `ClassCastException`***
    -  Less error prone code
    - Easy to debug code
  - Eliminate the over head of casting.
  - enables programmers to implement ***generic algorithm/generic programming*** - shorter code

## <u>Type Erasure and Generics</u>

-  It is a process in which compiler replaces a generic parameter with ***actual class or bridge method*** 

  - compiler ensure that no extra classes are created and there is **no runtime overhead**

- generic processing done at java by 3 steps: 

  - **Check** : type correctness
  - **Erase:** all generic type information
  - **Compile:** to byte code

  

- <u>**benefits of erasure:**</u>

  - binary compatibility to older library cause:`List<String>` :arrow_right: `List`(**raw type**)

- **<u>drawback of erasure:</u>**

  - generic type information is knot known at runtime
    
    - both `List<String>` and `List<Integer>` refer to `List`
    
      

- **<u>rules of type erasure</u>** 

  - Replace type parameters in generic type with their bound if bounded type parameters are used
  - Replace type parameters in generic type with Object if unbounded type parameters are used 
  - Insert type casts to preserve type safety 
  - Generate bridge methods to keep polymorphism in extended generic types

  

##  <u>Writing Codes Using Generics</u>

### <u>Some Definitions</u>

- **Generic Type** 

  - is a type with formal parameters

  - Example (of *generic type*):

    ```java
    interface Collection<E> {
        public void add(E x);
        public Iterator<E> iterator();
    }
    ```

     - here `E` is a type parameter

     - `E` is the place holder and will be replaced by a type argument when the generic type is instantiated

     - The instantiation of a generic type with actual type arguments is called a *parameterized type*

        - Example (of a parameterized type): 

          ```java
          Collection<String> coll = new LinkedList<String>();
          ```

          - the declaration of `Collection<String>` denotes a parameterized type. 

  

- **Raw Type** 

  - generic type without any type arguments

    - Example(of *raw type*): 

      ```java
      ArrayList rawList = new ArrayList(); 
      ArrayList<String> stringList = new ArrayList<String>();
      rawList = stringList;
      stringList = rawList;      // unchecked warning
      ```

    - the `rawList` here is a raw type `ArrayList`

      - it can contain any type of Object

      - it is equivalent to `ArrayList<Object>` 

        

- **Reifiable and Non-Reifiable Types:**

  - *reifiable* type is a type whose type information is fully available at runtime. This includes primitives, non-generic types, raw types, and invocations of unbound wildcards.
  - *Non-reifiable types*  are types where information has been removed at compile-time by type erasure — invocations of generic types that are not defined as unbounded wildcards. A non-reifiable type does not have all of its information available at runtime. Examples of non-reifiable types are `List<String>` and `List<Number>`; the JVM cannot tell the difference between these types at runtime. 
    - <span style="color:green; background-color:white;">*there are certain situations where non-reifiable types cannot be used: in an `instanceof` expression, for example, or as an element in an array.*</span>

  

- **Covariant Type**

  - This means that if one type of object can be substituted for another in a method (for instance, `Animal` can be replaced with `Dog`), the same applies to expressions using those objects (so `List<Animal>` could be replaced with `List<Dog>`).

    - covariance is not safe for **mutable**(where modification is possible after some object has been created) lists in general.

    - generics are not covariant (**invariant**)

      

- **Heap Pollution** 

  - In the Java programming language, **heap pollution** is a situation that arises when a variable of a parameterized type refers to an object that is not of that parameterized type. 

    - This situation is normally detected during compilation and indicated with an unchecked warning.
    -  Later, during runtime heap pollution will often cause a `ClassCastException`

    - A source of heap pollution in Java arises from the fact that type arguments and variables are not [reified](https://en.wikipedia.org/wiki/Reification_(computer_science)) at run-time. 

      - As a result, different parameterized types are implemented by the same class or interface at run time. Indeed, all invocations of a given generic type declaration share a single run-time implementation. This results in the possibility of heap pollution.

    - Example (of *heap pollution*)

      ```java
      public class HeapPollutionDemo
      {
         public static void main(String[] args)
         {
            Set s = new TreeSet<Integer>();
            Set<String> ss = s;            // unchecked warning
            s.add(new Integer(42));        // another unchecked warning
            Iterator<String> iter = ss.iterator();
            while (iter.hasNext())
            {
               String str = iter.next();   // ClassCastException thrown
               System.out.println(str);
            }
         }
      }
      ```

      

### <u>Generic Types</u> 

- *is generic class or interface that is parameterized over types* 

- <u>code snippet:</u> class without generics 

  ```java
  // A dynamically allocated array which holds a collection of java.lang.Object - without generics
  public class MyArrayList {
     private int size;  
     private Object[] elements;
     
     public MyArrayList() { 
        elements = new Object[10];
        size = 0;
     }
     
     public void add(Object o) {
        if (size < elements.length) {
           elements[size] = o;
        } else {
           // allocate a larger array and add the element, omitted
        }
        ++size;
     }
     
     public Object get(int index) {
        if (index >= size)
           throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        return elements[index];
     }
     
     public int size() { return size; }
  }
  
  //Testing MyArrayList
  public class MyArrayListTest {
     public static void main(String[] args) {
        // Intends to hold a list of Strings, but not type-safe
        MyArrayList strLst = new MyArrayList();
        // adding String elements - implicitly upcast to Object
        strLst.add("alpha");
        strLst.add("beta");
        // retrieving - need to explicitly downcast back to String
        for (int i = 0; i < strLst.size(); ++i) {
           String str = (String)strLst.get(i);
           System.out.println(str);
        }
     
        // Inadvertently added a non-String object will cause a runtime
        // ClassCastException. Compiler unable to catch the error.
        strLst.add(new Integer(1234));   // compiler/runtime cannot detect this error
        for (int i = 0; i < strLst.size(); ++i) {
           String str = (String)strLst.get(i);   // compile ok, runtime ClassCastException
           System.out.println(str);
        }
     }
  }
  ```

- <u>code snippet</u>: class with generics

  ```java
  // A dynamically allocated array with generics
  public class MyGenericArrayList<E> {
     private int size;
     private Object[] elements;
     
     public MyGenericArrayList() { 
        elements = new Object[10];
        size = 0;
     }
      
     public void add(E e) {
        if (size < elements.length) {
           elements[size] = e;
        } else {
           // allocate a larger array and add the element, omitted
        }
        ++size;
     }
     
     public E get(int index) {
        if (index >= size)
           throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        return (E)elements[index];
     }
     
     public int size() { return size; }
  }
  
  //Testing MyGenericArrayList
  public class MyGenericArrayListTest {
     public static void main(String[] args) {
         
        MyGenericArrayList<String> strLst = new MyGenericArrayList<String>();
        strLst.add("alpha"); // compiler checks if argument is of type String
        strLst.add("beta");
     
        for (int i = 0; i < strLst.size(); ++i) {
           String str = strLst.get(i); //compiler inserts the downcasting operator (String)
           System.out.println(str);
        }
     
        strLst.add(new Integer(1234)); // compiler detected argument is NOT String, issues compilation error
     }
  }
  ```

  - `MyGenericArrayList<E>` declare a generics class with a *formal type parameter* `<E>`. 
  - During an actual invocation (in main method), e.g., `MyGenericArrayList<String>`, a specific type `<String>`, or *actual type parameter*, replaced the formal type parameter `<E>`.
  - Behind the scene, generics are implemented by the Java compiler as a front-end conversion called *erasure*, which translates or rewrites code that uses generics into non-generic code (to ensure backward compatibility). This conversion erases all generic type information. For example, `ArrayList <Integer>` will become `ArrayList`. The formal type parameter, such as `<E>`, are replaced by `Object` by default (or by the upper bound of the type). When the resulting code is not type correct, the compiler insert a type casting operator.

- ##### Formal Type Parameter Naming Convention

  - Use an uppercase single-character for formal type parameter. For example,
    - `<E>` for an element of a collection;
    - `<T>` for type;
    - `<K, V>` for key and value.
    - `<N>` for number
    - `S`,`U`,`V`, etc. for 2nd, 3rd, 4th type parameters

### <u>Generic Method</u>

- ​	**code snippet:** 

  ```java
  //Example1: method with returning some List
  public <T> List<T> fromArrayToList(T[] a) {   
      return Arrays.stream(a).collect(Collectors.toList());
  }
  
  //Example2: method with no return
  public static <E> void ArrayToArrayList(E[] a, ArrayList<E> lst) {
     for (E e : a) lst.add(e);
  }
  
  
  //using the second method at Example2:
  ArrayList<Integer> lst = new ArrayList<Integer>();
  
  Integer[] intArray = {55, 66};  // autobox
  ArrayToArrayList(intArray, lst);
  for (Integer i : lst) System.out.println(i);
  
  String[] strArray = {"one", "two", "three"};
  ArrayToArrayList(strArray, lst);   // Compilation Error below
  ```

  - **Note** :

    - generic methods have a type parameter (the diamond operator enclosing the type) before the return type of the method declaration

  - a generic method can deal with more than one generic type, where in this is the case, all generic types must be added to the method signature

    ```java
    public static <T, G> List<G> fromArrayToList(T[] a, Function<T, G> mapperFunction) {
        return Arrays.stream(a)
          .map(mapperFunction)
          .collect(Collectors.toList());
    }
    
    //testing the above method
    Integer[] intArray = {1, 2, 3, 4, 5};
    List<String> stringList = Generics.fromArrayToList(intArray, Object::toString);
    ```

  


### <u>Generic Wildcard</u>

- Let we have following scenario:

  ```java
  class Animal{}
  class Cat extends Animal{}
  class Dog extends Animal{}
  
  List<Cat> cats = new ArrayList<>();
  List<Dog> dogs = new ArrayList<>();
  List<Animal> animals = new ArrayList<>();
  ```

- `Animal`, `Cat`, `Dog` all are  `Object` 

- now we want to write a single print Method that could able to print `List<Cat>` and `List<Dog>`

  - **attempt-1:**  method overloading (though not a single method) - hope it work

    ```java
    public void printDogs(List<Dog> dogs){} //1
    public void printCats(List<Cat> cats){} //2
    
    public void print(List<Dog> dogs){} //3
    public void print(List<Cat> cats){} //4
    ```

    - obviously 1 and 2 works. But we are looking for a more elegant solutions          
    - 2 and 3 (when written simultaneously) will not even compile. Because type erasure removes the *actual type parameters*   `Dog` and `Cat`. So for runtime these will be same `Object` -  `List`
  - **attempt-2:**  Parameterizing super class 
  
  ```java
    public void print(List<Animal> animals){} 
    ```
  
   - this will also not work, cause in Java [`List<Dog>` is not a `List<Animal>`.](https://stackoverflow.com/questions/2745265/is-listdog-a-subclass-of-listanimal-why-are-java-generics-not-implicitly-po)
  
      -  **Note:** 
  
         - though `List<Dog>` is not a `List<Animal>` 
  
         - but [`Dog[]` is `Animal[]`](https://stackoverflow.com/questions/2745265/is-listdog-a-subclass-of-listanimal-why-are-java-generics-not-implicitly-po/46496077#46496077) that means 
  
           ```java
             List<Animal> animals = new ArrayList<>();
             List<Dog> dogs = new ArrayList<>();
             animals = dogs //compilation error
                 
             Dog[] dogsArray = new Dog[10];
             Animal[] animalsArray = dogsArray;//compile;could produce error at tuntime 
             animalsArray[0] = new Cat();//throws ArrayStoreException at runtime
             
             ```
  
   - **Unbound Wildcard <?>:** 
  
      - To resolve this problem, a wildcard (`?`) is provided in generics, which stands for <u>***any unknown type***</u>. For example, we can rewrite our `print()` as follows to accept a `List` of any unknown type.
  
        ```java
          public static void print(List<?> list) {
            for (Object each : list) System.out.println(each);
          }
          ```
  
      - **Note:**
  
        ```java
          List<?> strings = new ArrayList<String>(); //compiles
          List<?> cats = new ArrayList<Cat>();  //compiles
          List<?> dogs = new ArrayList<Dog>(); //compiles
          
          List<Animal> animals = new ArrayList<Cat>(); //compilation error
          List<Object> objects = new ArrayList<Dog>(); //compilation error
          
          //But 
          List<?> nums = new ArrayList<Long>(); //compile
          nums.add(12387L); //1; not compile
          nums.clear(); //2; compile
          nums.add(null); // compile is 'any unknown type'
          ```
  
         - 1 will not compile, cause we do not know that 'nums' is a `List<Integer>`
  
         - 2 will compile `clear()` methods doesn't depends on generic parameter types 
  
           ```java
             public interface List<E> extends Collection<E> {
                 boolean add(E e);
             	void clear();
             }
             ```
  
   - **Upperboun Wildcard <? extends Type>:** 
  
      -  `<? extends Type>` stands for ***Type and its sub-types***. For example - `<? extends Number>` means - ''***Number and its sub-types***'' 	
  
        ```java
          public static void print(List<? extends Number> list) {
            for (Object o : list) System.out.println(o);
          }
          
          List<Integer> ints = new ArrayList<>();
          List<Long> longs = new ArrayList<>();
          List<Double> doubles = new Arraylist<>();
          List<String> strings = new ArrayList<>();
          List<Animal> animals = new ArrayList<>();
          List<Object> objects = new ArrayList<>();
          print(ints); //compile
          print(longs); //compile
          print(doubles); //compile
          print(strings); //not compile
          print(animals); //not compile
          print(objects); //not compile
          ```
  
         - 
  
         - 
  
         - <span style="color: red">*clearly <?> is equivalent to <? extends Object>* </span>     
  
         - *List<?> and List<Object> are not same*      
          
           - Some more example of upper bound uses     
          
             ```java
           // List<Number> lst = new ArrayList<Integer>();  // Compilation Error
             List<? extends Number> lst = new ArrayList<Integer>();
           ```
  
   - 
  
   - **Lowerbound Wildcard <? super Type>:**
  
     	-	 The wildcard `<? super Type>` matches ***Type and  its super-types***. In other words, it specifies the lower bound.
  
     - [**More Fun with Generics:**](https://docs.oracle.com/javase/tutorial/extra/generics/morefun.html)
  
        - **<u>Fun 1:</u>** 
  
          ```java
          List<? extends Animal> catList1 = new ArrayList<Cat>();
          catList1.add(new Cat("cat33")); //not compile; don't know it's a list of cat (List<Cat>)
          Cat c1 = catList1.get(0); //not compile 'required Cat - found Animal'
          Animal c2 = catList1.get(0); //compile
          
        List<? super Animal> catList2 = new ArrayList<Animal>();
          catList2.add(new Cat("cat34")); //compile
          Cat c3 = catList2.get(0); //not compile
        Animal c4 = catList2.get(0); //not compile
          ```

          - you *can't* add a `Cat` to a `List<? extends Animal>` because you don't know it's a `List<Cat>`. You can retrieve a value and know that it will be an `Animal`, but you can't add arbitrary animals.     
          - The reverse is true for `List<? super Animal>` - in that case you can add an `Animal` to it safely, but you don't know anything about what might be retrieved from it, because it could be a `List<Object>`  
  
         
  
       - <u>**Fun 2:**</u>
       
         

### <u>Java Generics FAQs and Resources</u>

- [Angelika Langer's Java Generic FAQ](http://www.angelikalanger.com/GenericsFAQ/FAQSections/ParameterizedTypes.html#Topic2)

  - very details discussion about generics

- Why [`List<Dog>` is not `List<Animal>`](https://stackoverflow.com/questions/2745265/is-listdog-a-subclass-of-listanimal-why-are-java-generics-not-implicitly-po) but [`Dog[]` is `Animal[]`](https://stackoverflow.com/questions/3246137/java-generics-cannot-cast-listsubclass-to-listsuperclass?noredirect=1&lq=1)

  ```java
      // All compiles but throws ArrayStoreException at runtime at last line
      Dog[] dogs = new Dog[10];
      Animal[] animals = dogs; // compiles
      animals[0] = new Cat(); // throws ArrayStoreException at runtime
  ```

-  

## <u>Some Concepts</u>

### <u>Collection vs. Collections</u>

- Collection:

  - `java.util.Collection`
  - base interface for most of the collection classes
  - it contains all common methods that may all type of collections should have like -  `add(), addAll(), isEmpty(), size()`

  

- Collections:

  - `java.util.Collections`
  - its a utility class 

  

### <u>Natural Order</u> 

### <u>Ordered vs. Sorted</u>

 - ***Ordered***

   	- 
 - ***Sorted***

    -   

  

