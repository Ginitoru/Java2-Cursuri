package db.ex2;

import javax.persistence.Entity;

@Entity
public class Avocat extends Anagajat{

    private String specializare;

    public String getSpecializare() {
        return specializare;
    }

    public void setSpecializare(String specializare) {
        this.specializare = specializare;
    }
}
