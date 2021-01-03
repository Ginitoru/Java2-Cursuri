package db.ex1;

import javax.persistence.Entity;

@Entity
public class Ciocolata extends Produs {

    private int Kcal;

    public int getKcal() {
        return Kcal;
    }

    public void setKcal(int kcal) {
        Kcal = kcal;
    }
}

