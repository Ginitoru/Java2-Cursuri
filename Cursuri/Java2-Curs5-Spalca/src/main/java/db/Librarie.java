package db;

import javax.persistence.*;
import java.util.Map;

@Entity
public class Librarie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToMany(cascade = CascadeType.ALL)
    private Map<String, Carte> carti;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Map<String, Carte> getCarti() {
        return carti;
    }

    public void setCarti(Map<String, Carte> carti) {
        this.carti = carti;
    }
}
