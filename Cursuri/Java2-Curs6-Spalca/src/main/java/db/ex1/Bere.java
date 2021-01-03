package db.ex1;

import javax.persistence.Entity;

@Entity
public class Bere  extends Produs{


    private double procentAlcool;

    public double getProcentAlcool() {
        return procentAlcool;
    }

    public void setProcentAlcool(double procentAlcool) {
        this.procentAlcool = procentAlcool;
    }
}
