package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("localhost", 4545);

        BufferedReader in  = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);



        out.println("hellow ");
        System.out.println(" s-a trimis helloow");
        out.println("world");
        System.out.println("s-a trimis wolrd");


        String result = in.readLine();
        System.out.println(result);



    }



}
