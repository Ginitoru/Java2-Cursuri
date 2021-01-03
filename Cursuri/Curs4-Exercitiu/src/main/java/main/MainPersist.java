package main;

import entities.Fisier;
import entities.Folder;
import entities.Rand;
import service.FisierService;
import service.FolderService;
import service.impl.ServiceProvider;

import java.util.List;

public class MainPersist {
    public static void main(String[] args) {

        FolderService fs = ServiceProvider.getInstance().get(FolderService.class);
        FisierService fs2 = ServiceProvider.getInstance().get(FisierService.class);

        Rand rand = new Rand();
        rand.setRand("bau bau bau hau hau ahu");

        Fisier f1 = new Fisier();
        f1.setAutor("fane");
        f1.setAccesCitire(true);
        f1.setAccesScriere(false);
        f1.setNumeFisier("fisier 1");
        f1.setRand(rand);

        Fisier f2 = new Fisier();
        f2.setAutor("gicu");
        f2.setNumeFisier("fisier 2");

        Folder folder = new Folder();
        folder.setNumeFolder("fodler 1");
        folder.setAutor("gigel");
        folder.setAccesCitier(true);
        folder.setAccesScriere(false);
        folder.setFisiere(List.of(f1, f2));

        f1.setFolder(folder);
        f2.setFolder(folder);

        fs.persist(folder);
        fs2.persist(f1);
        fs2.persist(f2);




    }
}
