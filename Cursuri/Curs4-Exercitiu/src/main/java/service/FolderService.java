package service;

import entities.Folder;

public interface FolderService {

    void persist(Folder folder);

    void delete(int id);

    Folder find(int id);


}
