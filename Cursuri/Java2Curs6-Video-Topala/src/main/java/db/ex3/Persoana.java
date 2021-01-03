package db.ex3;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Persoana {

    @EmbeddedId

    private NumePrenumeId id;

    private int varsta;

    public NumePrenumeId getId() {
        return id;
    }

    public void setId(NumePrenumeId id) {
        this.id = id;
    }

    public int getVarsta() {
        return varsta;
    }

    public void setVarsta(int varsta) {
        this.varsta = varsta;
    }
}
