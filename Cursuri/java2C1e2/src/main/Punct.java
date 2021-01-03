package main;

public class Punct {

    @Valoare(3)
    private int x ;

    @Valoare(7)
    private int y;

    private Punct(){}

    private void afis(){
        System.out.println(x + " " + y);
    }


}
