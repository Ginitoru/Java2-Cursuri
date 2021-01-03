package db;

import javax.persistence.*;
import java.util.Map;

@Entity
public class Scoala {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ElementCollection
    @Enumerated
    @CollectionTable(name ="tabela_materii")
    @MapKeyColumn(name = "numar_credite")
    private Map<Integer, Materie> materii;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Map<Integer, Materie> getMaterii() {
        return materii;
    }

    public void setMaterii(Map<Integer, Materie> materii) {
        this.materii = materii;
    }
}
