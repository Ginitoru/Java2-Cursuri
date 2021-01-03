package db;

import javax.persistence.*;
import java.util.Map;

@Entity
public class Tricou {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    private Map<String, Culoare> map;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Map<String, Culoare> getMap() {
        return map;
    }

    public void setMap(Map<String, Culoare> map) {
        this.map = map;
    }
}
