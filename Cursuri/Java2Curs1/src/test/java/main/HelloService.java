package main;

public class HelloService {

    public void sayHello(){
        System.out.println("hello");
    }

    @Log("log say bye")
    public void sayBye(){
        System.out.println("bye");
    }

}
