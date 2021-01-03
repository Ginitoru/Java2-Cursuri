package lib.dto;

import java.io.Serializable;

public class FileWorkerDTO implements Serializable {

    private String path;

    public FileWorkerDTO(String path) {
        this.path = path;
    }

    public FileWorkerDTO() {
    }

    public String getPath() {
        return path;
    }


}
