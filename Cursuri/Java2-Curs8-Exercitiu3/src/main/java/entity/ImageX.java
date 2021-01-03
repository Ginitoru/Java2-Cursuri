package entity;

import javax.persistence.*;

@Entity
public class ImageX {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;

    @Lob
    private byte[] image;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
