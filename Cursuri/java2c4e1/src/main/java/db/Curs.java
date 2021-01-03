package db;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Curs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nume;

    @ManyToMany(mappedBy = "cursuri")
    private Collection<Strudent> studenti;

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

    public Collection<Strudent> getStudenti() {
        return studenti;
    }

    public void setStudenti(Collection<Strudent> studenti) {
        this.studenti = studenti;
    }
}
