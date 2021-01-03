package db.ex5;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Masina {

    @EmbeddedId
    private License license;

    private String marca;

    public License getLicense() {
        return license;
    }

    public void setLicense(License license) {
        this.license = license;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
}
