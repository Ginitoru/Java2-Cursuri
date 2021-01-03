package db;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;

@Entity
public class Departament {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nume;

    @OneToMany(mappedBy = "departament", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private Collection<Angajat> angajati = new HashSet<>();

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

    public Collection<Angajat> getAngajati() {
        return angajati;
    }

    public void setAngajati(Collection<Angajat> angajati) {
        this.angajati = angajati;
    }
}
