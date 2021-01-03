package server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {


        try{

            ServerSocket ss = new ServerSocket(4444);

            Socket socket = ss.accept();

            BufferedReader in  = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            PrintStream out = new PrintStream(socket.getOutputStream(), true);

            int x = Integer.parseInt(in.readLine());
            int y = Integer.parseInt(in.readLine());

            out.println(x + y);
            System.out.println("serverul se inchide......");



        }catch(Exception e){
            e.printStackTrace();
        }




    }
}
