package dao;

import entities.Folder;

public interface FolderDao {

    void persist(Folder folder);

    void delete (Folder folder);

    Folder find(int id);

}
