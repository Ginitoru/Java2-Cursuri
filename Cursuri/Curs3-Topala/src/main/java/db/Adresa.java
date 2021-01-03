package db;

import javax.persistence.Column;
import javax.persistence.Embeddable;


//adresa nu este o entitate=> nu are o tabela a ei
// - nu are id
@Embeddable
public class Adresa {

    @Column(name = "nr_strada")
    private String strada;

    private int nr;

    public String getStrada() {
        return strada;
    }

    public void setStrada(String strada) {
        this.strada = strada;
    }

    public int getNr() {
        return nr;
    }

    public void setNr(int nr) {
        this.nr = nr;
    }
}
