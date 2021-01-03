package reflection;

import main.MyAnnotation;

public class Pisica {

    @MyAnnotation("tom")
    private String nume;

    private Pisica(){
        System.out.println("ctr pisica");
    }


    private void miau(){
        System.out.println("Miau " + nume);
    }

}
