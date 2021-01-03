package server.entity;

import javax.persistence.*;
import java.util.Arrays;


@Entity
@NamedQuery(name ="BackGroudnImage.finAll", query = "Select i FROM BackGroundImage i ")
public class BackGroundImage {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;

    @Lob
    private byte [] image;


    public BackGroundImage() {
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
        BackGroundImage that = (BackGroundImage) o;
        return Arrays.equals(image, that.image);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(image);
    }
}
