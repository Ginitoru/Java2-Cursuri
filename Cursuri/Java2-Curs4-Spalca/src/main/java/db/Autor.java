package db;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String  nume;

    @ManyToMany
    private Collection<Articol> articole;

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

    public Collection<Articol> getArticole() {
        return articole;
    }

    public void setArticole(Collection<Articol> articole) {
        this.articole = articole;
    }
}

