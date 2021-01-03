package server;

import java.net.ServerSocket;
import java.net.Socket;

public class ServerEngine {

    private ServerSocket ss;

    private ServerEngine() {
        try{

          ss = new ServerSocket( 4444);
        }catch(Exception e){


            e.printStackTrace();
        }
    }


    private static final class SingletonHolder{
        public static final ServerEngine INSTANCE = new ServerEngine();
    }

    public static ServerEngine getInstance(){
        return SingletonHolder.INSTANCE;
    }


    public ServerThread connectClient() throws Exception{
        Socket socket = ss.accept();
        ServerThread st = new ServerThread(socket);
        st.start();

        return st;

    }



}
