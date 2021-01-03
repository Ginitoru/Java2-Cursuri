package db;


import javax.persistence.*;

@Entity
public class Organizatie {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String site;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "strada", column = @Column(name = "org_strada"))


    })
    private Adresa adrsa;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public Adresa getAdrsa() {
        return adrsa;
    }

    public void setAdrsa(Adresa adrsa) {
        this.adrsa = adrsa;
    }
}
