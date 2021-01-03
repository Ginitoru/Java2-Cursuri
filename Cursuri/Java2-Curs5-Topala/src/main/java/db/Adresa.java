package db;

import javax.persistence.*;

@Entity
public class Adresa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String strada;

    @ManyToOne
    private Organizatie organizatie;

    public int getId() {
        return id;
    }

    @ManyToOne
    private Persoana persoana;

    public void setId(int id) {
        this.id = id;
    }

    public String getStrada() {
        return strada;
    }

    public void setStrada(String strada) {
        this.strada = strada;
    }

    public Organizatie getOrganizatie() {
        return organizatie;
    }

    public void setOrganizatie(Organizatie organizatie) {
        this.organizatie = organizatie;
    }

    public Persoana getPersoana() {
        return persoana;
    }

    public void setPersoana(Persoana persoana) {
        this.persoana = persoana;
    }

    @Override
    public String toString() {
        return "Adresa{" +
                "persoana=" + persoana +
                '}';
    }
}
