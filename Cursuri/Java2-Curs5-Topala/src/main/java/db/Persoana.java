package db;

import javax.persistence.*;
import java.util.Map;

@Entity
public class Persoana {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToMany(mappedBy = "persoana")
    @MapKey(name = "strada")//specifica numele fieldului din entitatea Adresa
                            // a carui valoare va fi pusa drept cheie asociata Adresei
    private Map<String, Adresa> adresa;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Map<String, Adresa> getAdresa() {
        return adresa;
    }

    public void setAdresa(Map<String, Adresa> adresa) {
        this.adresa = adresa;
    }


}
