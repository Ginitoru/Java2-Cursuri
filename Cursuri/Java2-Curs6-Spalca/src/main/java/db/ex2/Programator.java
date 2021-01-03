package db.ex2;

import javax.persistence.Entity;

@Entity
public class Programator extends Anagajat{

    private String limbaj;

    public String getLimbaj() {
        return limbaj;
    }

    public void setLimbaj(String limbaj) {
        this.limbaj = limbaj;
    }
}
