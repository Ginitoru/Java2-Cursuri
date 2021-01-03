package exercitii;

public class Ex2 {

    public static void main(String[] args) {

        int  [] x = new int[]{20,30,40,50,60,70,80,90};

        array(x);


    }

    public static void array(int[] x){
      int z;
      int mij = x.length / 2;


      if(x.length % 2 != 0){
          for(int i = 0;  mij + i < x.length; i++){
              z = x[mij - i];
              x[mij - i] = x[mij +i];
              x[mij + i] = z;
          }

      }else{

          for(int i = 0; mij + i < x.length; i++){
              z = x[mij - i - 1];
              x[mij  - i-1] = x[mij + i];
              x[mij + i] = z;
          }

      }

        for(int c: x){
            System.out.print(c + " ");
        }

    }
}
