package db;


import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;

@Entity
public class Produs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private int pret;

    private String nume;

    @ManyToMany
    private Collection<Factura> facturi = new HashSet<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPret() {
        return pret;
    }

    public void setPret(int pret) {
        this.pret = pret;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public Collection<Factura> getFacturi() {
        return facturi;
    }

    public void setFacturi(Collection<Factura> facturi) {
        this.facturi = facturi;
    }
}
