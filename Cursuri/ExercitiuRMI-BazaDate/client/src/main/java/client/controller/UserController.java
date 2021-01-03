package client.controller;

import lib.dto.UserDTO;
import lib.dto.service.UserService;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class UserController implements UserService {

    private UserService userService;

    private UserController() {
        try {
            Registry registry  = LocateRegistry.getRegistry("localhost",4545);
            userService = (UserService) registry.lookup("userService");

        } catch (RemoteException | NotBoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    private static final class SingletonHolder{
        public static  UserController INSTNACE = new UserController();
    }

    public static UserController getInstance(){
        return SingletonHolder.INSTNACE;
    }





    @Override
    public int login(UserDTO userDTO){
        try {
            return userService.login(userDTO);
        } catch (RemoteException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public int signin(UserDTO userDTO){
        try {
            return userService.signin(userDTO);
        } catch (RemoteException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
