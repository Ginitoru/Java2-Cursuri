package db;

import javax.persistence.*;

@Entity
public class Organizatie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Embedded
    @AttributeOverride(name = "strada", column = @Column(name = "strada_org"))
    //suprascriu atributul cu numele "strada" din clasa Adrsea
    //cu coloana precizata pe atributul column
    private Adresa adresa;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Adresa getAdresa() {
        return adresa;
    }

    public void setAdresa(Adresa adresa) {
        this.adresa = adresa;
    }
}
