package db;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "PRODUSE")
public class Produs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "produs_id")
    private int id;


    @Column(name = "produs_nume", nullable = false)
    private String nume;

    @Basic(fetch = FetchType.EAGER)
    @Temporal(value = TemporalType.DATE)
    private Date expirare;

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }


    private Categorie categorie;

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
    }

    public Date getExpirare() {
        return expirare;
    }

    public void setExpirare(Date expirare) {
        this.expirare = expirare;
    }

    @Override
    public String toString() {
        return "Produs{" +
                "id=" + id +
                ", nume='" + nume + '\'' +
                ", expirare=" + expirare +
                ", categorie=" + categorie +
                '}';
    }

}
