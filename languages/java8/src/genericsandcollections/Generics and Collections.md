# <u>Generic and Collections</u>

## <u>Why Generics  / The Motivation for Generics</u> {#motivation-link}

- consider the following 2 code snippet where generics are not used

  ```java
  //without generics
  class Apple{}
  class Bird{}
  ...
  List box1 = new ArrayList();//1
  box1.add(new Apple());
  box2.put(new Bird()) //2
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
  - [4,5,6] - now we have create the `box2` using generic. And the `box2` is meant for storing only `Apple`. Goring further, when we put anything but `Apple`  at `box2` we will get a compilation error.  

- Notice the following code snippet  

  ```java
  Integer[] integerArray = new Integer[10];
  Long[] longArray = new Long[11];
  Double[] doubleArray = new Double[12];
  ....
  //if we want to print the Array we can use the following 3 different methods
  public void printIntegerArray(Integer[] array){}
  public void printLongArray(Long[] array){}
  public void printDoubleArray(Double[] array){}
  ```

  -  but if we use generic then we can use only a single method to print all of the list - ***generics enables types to be parameters***

  ```java
  //using generic the all 3 methods could be wrie in a single method 
  <T> void printArray(T[] array) {
       for(T item : array){
            System.out.println(item);
       }
  }
  ```

  - we are here passing type as parameter

- **In a nutshell,**

  - generics enable ***types (classes and interfaces) to be parameters*** when defining classes, interfaces and methods. 

    - Much like the more familiar ***formal parameters*** used in method declarations, **type parameters** provide a way for you to re-use the same code with different inputs. 
      - The difference is that the inputs to ***formal parameters*** are values, while the inputs to ***type parameters*** are types.

    

## <u>Advantage of Generics</u>

- based on the [above discussion](#motivation-link) 
  - 

## <u>Type Erasure and Generics</u>

##  <u>Writing Codes Using Generics</u>

### <u>Generic Class</u>

### <u>Generic Method</u>



## <u>Some Concepts</u>

### <u>Collection vs. Collections</u>

### <u>Natural Order</u> 

### <u>Ordered vs. Sorted</u>

 - ***Ordered***

   	- 

 - ***Sorted***

    -  

      

