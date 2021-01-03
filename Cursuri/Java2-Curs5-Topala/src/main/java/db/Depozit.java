package db;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
@Cacheable(value = true) //activam cache-ingul pt queruri pe entiatea depozit
public class Depozit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ElementCollection
    @MapKeyColumn(name = "adresa_id")
    private Map<Adresa, String> firme = new HashMap<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Map<Adresa, String> getFirme() {
        return firme;
    }

    public void setFirme(Map<Adresa, String> firme) {
        this.firme = firme;
    }
}
