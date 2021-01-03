package lib.dto;

import java.io.Serializable;
import java.util.Arrays;

public class BackGroundImgDTO implements Serializable {

    private int id;

    private byte [] image;

    public BackGroundImgDTO() {
    }


    public int getId() {
        return id;
    }

    public byte[] getImage() {
        return image;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BackGroundImgDTO that = (BackGroundImgDTO) o;
        return Arrays.equals(image, that.image);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(image);
    }
}
