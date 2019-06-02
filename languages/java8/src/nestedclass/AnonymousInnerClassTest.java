package nestedclass;

abstract class AnonymousInnerClass{
    public abstract  void myMethod();
}

interface Message {
    //modifier public is redundent in interface
    String greet();
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

class AnonymousInnerClassTest2 {

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
