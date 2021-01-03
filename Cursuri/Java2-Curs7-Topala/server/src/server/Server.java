package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(4545);

        System.out.println("astept conexiuni");

        Socket client = serverSocket.accept();


        System.out.println("un client s-a conectat");

        //deschid fluxul de intrare de la client in aplicatie
        BufferedReader in = new BufferedReader( new InputStreamReader(client.getInputStream()));

        //deschid fluxul de iesire de la aplicatie catre client
        PrintWriter out = new PrintWriter(client.getOutputStream(), true);


        String line =  in.readLine();

        System.out.println("am citit" + line);
        String reversed = new StringBuilder(line).reverse().toString();
        out.println(reversed);

        System.out.println("am afisat" + reversed);

        //trebuia in try cu resurse
        in.close();
        out.close();
        serverSocket.close();

        System.out.println("server inchis");

    }
}
