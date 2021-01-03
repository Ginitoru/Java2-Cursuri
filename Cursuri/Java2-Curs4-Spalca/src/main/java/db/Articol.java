package db;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Articol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String titlu;

    @ManyToMany(mappedBy = "articole")
    private Collection<Autor> autori;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitlu() {
        return titlu;
    }

    public void setTitlu(String titlu) {
        this.titlu = titlu;
    }

    public Collection<Autor> getAutori() {
        return autori;
    }

    public void setAutori(Collection<Autor> autori) {
        this.autori = autori;
    }
}
