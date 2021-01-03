package db.ex5;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class License implements Serializable {

    private String regieun;

    private int nr;

    private String cod;

    public String getRegieun() {
        return regieun;
    }

    public void setRegieun(String regieun) {
        this.regieun = regieun;
    }

    public int getNr() {
        return nr;
    }

    public void setNr(int nr) {
        this.nr = nr;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        License license = (License) o;
        return nr == license.nr &&
                Objects.equals(regieun, license.regieun) &&
                Objects.equals(cod, license.cod);
    }

    @Override
    public int hashCode() {
        return Objects.hash(regieun, nr, cod);
    }
}
