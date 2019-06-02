# <u>Nested Class</u>

- class written within another class  (the **enclosing** class or **outer** class)
- ***Classification***:

![inner_classes](./inner_classes.jpg)

- also known as  : **_non-static inner class_**

## <u>(Non static) Inner Class</u>

 - directly resides in the enclosing class: full fledge member of the class

    - like methods, fields
    - so it could treat as class member
      	- it could be `private`
       - it could be `abstract`, `final`
          - but not both `abstract` and `final` at the same time
            	- `abstract` class are meant to be always subclass wheres, `final` classes can't never be subclassed. 

- it has a special relationship with its **outer/enclosing** class - inner class can access all of the member of it's **outer/enclosing** class even it they are marked as `private` 

- ***Code Snippet:***

  ```java
  public class MyOuterClass {
      //MyInnerClass could also be private
      public class MyInnerClass{
          public void doStuff(){}
      }
      
      //case1: from inside the enclosing outer class
      MyInnerClass mic = new MyInnerClass
  }
  
  //case 2: from outside of the MyOuterClass
  MyOuterClass moc = new MyCouterClass();
  MyOuterClass.MyInnerClass = moc.new MyInnerClass();
  ```

  - if the `MyInnerClas`  would `private` then it could not be accessed like in `case 2` above. 
    - we need to create a public (getter-like) method at it's outer class (`MyOuterClass`) to access the instance member of the `MyInnerClass` from outer world
  - `this` vs. `MyOuterClass.this`

  ```java
  //this reference
  
  public class MyOuterClass{
      private int value = 25;
      
      public class MyInnerClass{
      	private int value = 26;
          System.out.println(value);//26
          System.out.println(this.value);//26
          System.out.println(MyouterClass.this.value);//25
      }
  }
  ```

  

## <u>Method Local Inner Class</u>

- defined within a method of an enclosing class
- to use it you must need to instantiate it 
  - only in the method where it has been declared (scope bounded to method)
  - only after the class definition code

- it can not use method local **variables** and **parameters** : unless they are marked `final`
  - but it's not completely true for java 8. Java 8 introduced ***effectively final*** .
    - read more in [stackoverflow](https://stackoverflow.com/questions/38291734/accessing-local-variables-from-method-local-inner-class-in-which-we-declare-the)
- only modifier a method local inner class can take : `abstract` an d`final` (but not both of them at the same time)
- ***Questions:***
  - can a method local inner class use the enclosing class member like - method, fields (specially when they are private)?
    - TODO : need to check

## <u>Anonymous Inner Class</u>

- class with no name

  - type : 
    - subclass of any named type or
    - implementation of the named interface

- anonymous inner class always declared as part of a statement - always ends with semicolon  - `};` or `});`

- ***Code Snippet:***

  ```java
  abstract class AnonymousInnerClass{
      public abstract  void myMethod();
  }
  
  public class AnonymousInnerClassTest {
  
      public static void main(String[] args) {
          AnonymousInnerClass innerClass = new AnonymousInnerClass() {
              @Override
              public void myMethod() {
                  System.out.println("I'm in AnonymousInner.myMethod()");
              }
          };
          //note the semiclon above after '}'- not an usual sytenx in java
          innerClass.myMethod();
      }
  }
  ```

  ```java
  interface Message{
      String greet();
  }
  
  public class AnonymousInnerClassTest2 {
      public void displayMessage (Message m){
          System.out.println(m.greet());
      }
  
      public static void main(String[] args) {
          AnonymousInnerClassTest2 ait2 = new AnonymousInnerClassTest2();
          ait2.displayMessage(new Message() {
              @Override
              public String greet() {
                  return "Hello from anonymous class instance method!";
              }
          });
      }
  }
  ```

  

## <u>Static Nested Class</u> 

 - resides directly inside the **enclosing** class with `static` modifier

   	- not considered as *inner class* 
   	- rather a top level nested class

 - because the nested class is static no - special relation to it's **enclosing** class

   	- it can not access any **non-static** member of it's **enclosing** class

 - ***Code Snippet:*** 

   ```java
   public class BigOuter{
       public static class Nested{}
   }
   
   //from outside of the class
   BigOuter.Nested n = new BigOuter.Nested();
   ```

   









