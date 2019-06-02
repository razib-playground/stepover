package nestedclass;

class BigOuter {

    private static long area=2L;

    public static class Nested{

        public void doStuf() {
            //static nested class can only access enclosing class's static members
            area = 25*25;
            System.out.println("area: " + area);
        }
    }
}

public class StaticNestedClass{
    public static void main(String[] args) {
        System.out.println("Hello Word");

        //instantiating static nested class
        BigOuter.Nested n = new BigOuter.Nested();
        n.doStuf();
    }
}

