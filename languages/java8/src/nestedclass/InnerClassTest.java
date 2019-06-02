package nestedclass;

class MyOuterClass{

    int length = 15;
    private int width = 15;
    public int area = 0;

    public class MyInnerClass{
        private double area = length*width;

        public double getAreaDouble() {
            return area;
        }

        public int getAreaInt() {
            return MyOuterClass.this.area;
        }
    }

}

public class InnerClassTest {

    public static void main(String[] args) {
        MyOuterClass moc = new MyOuterClass();
        MyOuterClass.MyInnerClass mic = moc.new MyInnerClass();

        System.out.println("Area Double: " +mic.getAreaDouble());
        System.out.println("Area Int: " +mic.getAreaInt());

    }
}
