package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {

        String ip = "localhost";
        int port = 4545;

        System.out.println("ma conectez la server......");


        //obtin conexiunea cu un server care ruleaza pe sistemul curent la portul 4545
        Socket server = new Socket(ip, port);

        System.out.println("m-am conectat la server");


        PrintWriter out = new PrintWriter(server.getOutputStream(), true);

        BufferedReader in  =  new BufferedReader( new InputStreamReader( server.getInputStream()));

        out.println("hello!");

        String result = in.readLine();


        System.out.println("am obtinut " + result);

        out.close();
        in.close();
        server.close();

        System.out.println("conexiune incheiata");


    }
}
