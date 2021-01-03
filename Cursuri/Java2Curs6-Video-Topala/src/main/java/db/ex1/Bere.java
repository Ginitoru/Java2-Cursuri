package db.ex1;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
        @NamedQuery(name = "Bere.faindAll", query = "SELECT b From Bere b"),

})
public class Bere extends Produs {

private int alcool;

    public int getAlcool() {
        return alcool;
    }

    public void setAlcool(int alcool) {
        this.alcool = alcool;
    }
}
