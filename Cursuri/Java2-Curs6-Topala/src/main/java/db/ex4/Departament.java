package db.ex4;

import db.ex2.Programator;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Collection;
import java.util.HashSet;

@Entity
public class Departament {

    @Id
    private int id;

    @ManyToMany(cascade = CascadeType.PERSIST)
    private Collection<Programator> programatori = new HashSet<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Collection<Programator> getProgramatori() {
        return programatori;
    }

    public void setProgramatori(Collection<Programator> programatori) {
        this.programatori = programatori;
    }
}
