package db.ex1;

import javax.persistence.Entity;

@Entity
public class Caine extends Animal {

    private int varsta;

    public int getVarsta() {
        return varsta;
    }

    public void setVarsta(int varsta) {
        this.varsta = varsta;
    }
}
