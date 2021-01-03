package db.ex4;

import javax.persistence.Entity;

@Entity
public class Java extends Curs {

    private int durata;

    public int getDurata() {
        return durata;
    }

    public void setDurata(int durata) {
        this.durata = durata;
    }
}
