package pachet;

import java.lang.reflect.Field;

public class Ex1 {
    public static void main(String[] args) throws Exception {

        var caine = getCaine();

        System.out.println(caine.varsta);
    }

    private static Caine getCaine() throws Exception{
        Class<Caine> caineClass = Caine.class;
        Field varstaField = caineClass.getDeclaredField("varsta");

        Caine instance = new Caine();

        Random annotation = varstaField.getDeclaredAnnotation(Random.class);
        int value = annotation.value();

        java.util.Random random = new java.util.Random();
        int varsta = random.nextInt(value);

        varstaField.setAccessible(true);
        varstaField.set(instance, varsta);

        return instance;

    }
}
