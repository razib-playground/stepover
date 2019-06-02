package nestedclass;

class OuterClass{
    private int a = 21;
    private static int b = 22;
    private static final int c = 23;

    public void method (final int x, int y) {
        int sum = a+b+c;
        System.out.println(a + b + c); //all a, b,c can be accessible from this non static method.

        class MethodLocalInnerClass{
            int sum2 = a + b + c; // all fields are accessible

            public void innerMethod() {
                System.out.println("Sum:" +sum);
                System.out.println("Sum2:" +sum2); //all a, b,c can be accessible from this non static method.
                System.out.println("ParemSum:" +(x+y) );

            }
        }

        MethodLocalInnerClass methodLocalInnerClass = new MethodLocalInnerClass();
        methodLocalInnerClass.innerMethod();

    }

    public static void method2(){
        //int sum = a+b+c; //non-static field 'a' can not be referenced from static context
        int sum = b+c; //only static fields are accessible from static method
    }

}

public class MethodLocalInnerClassTest {
    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass();
        outerClass.method(2, 3);
    }
}
