package db;

import javax.persistence.*;

@Entity
public class Tricou {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.ORDINAL)
    private Marime marime;

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    @Basic(optional = true, fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private Material material;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Marime getMarime() {
        return marime;
    }

    public void setMarime(Marime marime) {
        this.marime = marime;
    }

    @Override
    public String toString() {
        return "Tricou{" +
                "id=" + id +
                ", marime=" + marime +
                '}';
    }
}
