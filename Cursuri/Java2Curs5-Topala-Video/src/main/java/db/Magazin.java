package db;

import javax.persistence.*;
import java.util.Map;

@Entity
public class Magazin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ElementCollection
    private Map<Integer, String> departamente;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Map<Integer, String> getDepartamente() {
        return departamente;
    }

    public void setDepartamente(Map<Integer, String> departamente) {
        this.departamente = departamente;
    }
}
