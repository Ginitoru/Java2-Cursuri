package db;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
public class Tricou {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ElementCollection
    @MapKeyColumn(name = "marime_tricou")//config coloana la care va fi mapata cheia map-ului
    @MapKeyEnumerated(EnumType.STRING)//config modul de stocare din cheia map-ului
    private Map<Marime, String> modele = new HashMap<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Map<Marime, String> getModele() {
        return modele;
    }

    public void setModele(Map<Marime, String> modele) {
        this.modele = modele;
    }
}
