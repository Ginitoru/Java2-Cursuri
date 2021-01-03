package proxy;

public class HelloService {

    public void sayHello(){
        System.out.println("hello");
    }

    @Log("say bye")
    public void bye(){
        System.out.println("bye");
    }
}
