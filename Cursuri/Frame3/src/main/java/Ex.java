public class Ex {

    public static void main(String[] args) {

        XXX x = XXX.getInstance();

        System.out.println(x);

        XXX y = XXX.getInstance();

        System.out.println(y);


        System.out.println("+++++++++++++++++++++");

        y.setX(10);




        System.out.println(x);
        System.out.println(y);

    }

}
