package db;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Scoala {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nume;

    @OneToMany(mappedBy = "scoala", fetch = FetchType.LAZY)
    private Collection<Profesor> profesor;

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

    public Collection<Profesor> getProfesor() {
        return profesor;
    }

    public void setProfesor(Collection<Profesor> profesor) {
        this.profesor = profesor;
    }
}
