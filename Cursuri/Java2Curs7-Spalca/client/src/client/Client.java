package client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {


    public static void main(String[] args) {

        try{

            Socket socket = new Socket("localhost", 4444);

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));


            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println("hellow world");
            String line = in.readLine();

            System.out.println("server " + line);





        }catch(Exception e){

        }



    }
}
