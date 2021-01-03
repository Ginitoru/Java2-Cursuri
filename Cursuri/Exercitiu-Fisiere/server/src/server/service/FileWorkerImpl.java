package server.service;

import lib.dto.FileWorkerDTO;
import lib.service.FileWorkerService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.stream.Collectors;

public class FileWorkerImpl extends UnicastRemoteObject implements FileWorkerService {

    private Path p1 = Paths.get("./server/src/server/fisiere");

    public FileWorkerImpl() throws RemoteException {
    }

    @Override
    public List<String> showFiles() throws RemoteException {
        try {
              return Files.list(p1)
                     .map(p ->p.toString()+"\n")
                      .collect(Collectors.toList());


        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void changeDirectory(FileWorkerDTO fileWorkerDTO) throws RemoteException {
        Path p2 = Paths.get(fileWorkerDTO.getPath());

        p1 = p2;
        System.out.println(p1);
    }

    @Override
    public void createFile(FileWorkerDTO fileWorkerDTO) throws RemoteException {
        Path p2 = Paths.get(fileWorkerDTO.getPath());

        Path p21 = p1.resolve(p2);

        System.out.println(p21.toString());

        try {

          Files.createFile(p21);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteFile(FileWorkerDTO fileWorkerDTO) throws RemoteException {
            Path p21 = p1.resolve(fileWorkerDTO.getPath());

        try {
            Files.deleteIfExists(p21);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void renameFile(FileWorkerDTO fileWorkerDTO) throws RemoteException {
     //   Path p21 = Paths.get(fileWorkerDTO.getPath());

        String [] z = fileWorkerDTO.getPath().split(" ");
//
        Path x1 = Paths.get(z[0]);




//        System.out.println(x1 + "ccccc");
//        System.out.println(z[1] + "vvvvvvv");

        try {
            Files.move(x1 ,x1.resolveSibling(z[1]));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //todo: mai vedem

    }

    @Override
    public void createDirectory(FileWorkerDTO fileWorkerDTO) throws RemoteException {
        Path p2 = Paths.get(fileWorkerDTO.getPath());

        Path p21 = p1.resolve(p2);

        try {
            Files.createDirectories(p21);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
