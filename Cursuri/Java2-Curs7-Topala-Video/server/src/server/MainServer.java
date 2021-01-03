package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MainServer {
    public static void main(String[] args) throws IOException {

        ServerSocket ss = new ServerSocket( 4545);
        System.out.println("serverul a pornit portul 4545");

        System.out.println("se astepata clienti");
        Socket client = ss.accept();


        BufferedReader in  = new BufferedReader(new InputStreamReader(client.getInputStream()));

        PrintWriter out = new PrintWriter(client.getOutputStream(),true);


        String s1 = in.readLine();
        System.out.println("am primit s1");

        String s2 = in.readLine();
        System.out.println("am primit s2");

        String s3 = s1+s2;

        out.println(s3);
        System.out.println("am trimis " + s3);






    }
}
