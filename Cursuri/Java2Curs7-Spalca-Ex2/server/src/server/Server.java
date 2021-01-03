package server;

public class Server {




    public static void main(String[] args) {




        try{



            while(true){
              ServerThread st =  ServerEngine.getInstance().connectClient();
                ClientsContainer.addClient(st);

            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }




}
