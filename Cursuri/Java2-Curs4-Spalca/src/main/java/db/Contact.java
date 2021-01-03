package db;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nume;

    @ElementCollection
    @CollectionTable(name = "legaturac_colectie")
    private Collection<String> numere;

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

    public Collection<String> getNumere() {
        return numere;
    }

    public void setNumere(Collection<String> numere) {
        this.numere = numere;
    }
}
