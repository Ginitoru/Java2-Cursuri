package db;

import javax.persistence.*;

@Entity
public class Carte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nume;

    @ManyToOne()
    private Librarie libratie;

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

    public Librarie getLibratie() {
        return libratie;
    }

    public void setLibratie(Librarie libratie) {
        this.libratie = libratie;
    }
}
