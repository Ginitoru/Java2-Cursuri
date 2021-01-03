package db;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
public class Folder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nume;

    @OneToMany(cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
    private List<Fisier> fisier;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public Collection<Fisier> getFisier() {
        return fisier;
    }

    public void setFisier(List<Fisier> fisier) {
        this.fisier = fisier;
    }
}
