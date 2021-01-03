package server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {







    public static void main(String[] args) {

        try{
            System.out.println("se incerca deschdierea portului 4444");
            ServerSocket ss = new ServerSocket(4444);
            System.out.println("portul 4444 a fost deschis");
            System.out.println("se asteapta un client.....");
            Socket socket =  ss.accept();

            System.out.println("clientul s-a conectat");
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            System.out.println("se astepta un mesaja");

            String line = in.readLine();

            out.println(new StringBuilder(line).reverse().toString());
            System.out.println("am primit " + line);
            System.out.println("serverul se inchide");


        }catch(Exception e){
            e.printStackTrace();
        }


    }



}
