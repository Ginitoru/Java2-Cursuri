package db;

import javax.persistence.*;
import java.util.Map;

@Entity
public class Catalog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ElementCollection
    private Map<Student, Integer> medii;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Map<Student, Integer> getMedii() {
        return medii;
    }

    public void setMedii(Map<Student, Integer> medii) {
        this.medii = medii;
    }
}
