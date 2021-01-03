package entities;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
public class Avion {

    private String numeAvion;

    @Enumerated(EnumType.STRING)
    TipAvion tipAvion;

    public String getNumeAvion() {
        return numeAvion;
    }

    public void setNumeAvion(String numeAvion) {
        this.numeAvion = numeAvion;
    }

    public TipAvion getTipAvion() {
        return tipAvion;
    }

    public void setTipAvion(TipAvion tipAvion) {
        this.tipAvion = tipAvion;
    }
}
