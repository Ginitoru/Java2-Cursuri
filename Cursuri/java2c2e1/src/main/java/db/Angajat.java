package db;

import javax.persistence.*;

@Entity
@Access(AccessType.PROPERTY)
public class Angajat {


    private int id;

    private String nume;


    private int varsta;

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Access(AccessType.FIELD)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
        System.out.println("setter nume");
    }

    public int getVarsta() {
        return varsta;
    }

    public void setVarsta(int varsta) {
        this.varsta = varsta;
    }

    @Override
    public String toString() {
        return "Anagajat{" +
                "id=" + id +
                ", nume='" + nume + '\'' +
                ", varsta=" + varsta +
                '}';
    }
}
