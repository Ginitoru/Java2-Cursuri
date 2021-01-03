package db;

import javax.persistence.*;
import java.util.Map;

@Entity
public class Persoana {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ElementCollection
    private Map<String, String> prieteni;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Map<String, String> getPrieteni() {
        return prieteni;
    }

    public void setPrieteni(Map<String, String> prieteni) {
        this.prieteni = prieteni;
    }
}
