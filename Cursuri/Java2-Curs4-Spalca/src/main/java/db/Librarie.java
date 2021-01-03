package db;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Librarie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String adresa;

    @OneToMany(mappedBy = "libratie")
    private Collection<Carte> carti;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public Collection<Carte> getCarti() {
        return carti;
    }

    public void setCarti(Collection<Carte> carti) {
        this.carti = carti;
    }
}
