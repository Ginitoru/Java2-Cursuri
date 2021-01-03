package main;

import service.FisierService;
import service.FolderService;
import service.impl.ServiceProvider;

public class MainRemove {
    public static void main(String[] args) {
        FolderService fs1 = ServiceProvider.getInstance().get(FolderService.class);
        FisierService fs2 = ServiceProvider.getInstance().get(FisierService.class);




        fs1.delete(17);




    }


}
