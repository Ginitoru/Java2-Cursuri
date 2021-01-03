package entities;

import javax.persistence.Embeddable;

@Embeddable
public class Rand {

    private String rand;

    public String getRand() {
        return rand;
    }

    public void setRand(String rand) {
        this.rand = rand;
    }
}
