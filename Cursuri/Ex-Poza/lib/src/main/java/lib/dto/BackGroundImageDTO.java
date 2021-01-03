package lib.dto;

import java.io.Serializable;
import java.util.Arrays;

public class BackGroundImageDTO implements Serializable {

    private int id;

    private byte [] image;

    public BackGroundImageDTO() {
    }

    public int getId() {
        return id;
    }

    public byte[] getImage() {
        return image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BackGroundImageDTO that = (BackGroundImageDTO) o;
        return Arrays.equals(image, that.image);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(image);
    }
}
