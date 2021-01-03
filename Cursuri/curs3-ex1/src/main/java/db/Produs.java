package db;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "PRODUSE")
public class Produs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tid;

    @Column(name = "produs_name")
    private String nume;


    @Basic(fetch = FetchType.EAGER)
    @Temporal(TemporalType.DATE)
    private Date expirare;



    @Enumerated(EnumType.STRING)
    private Categorie categorie;


    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public Date getExpirare() {
        return expirare;
    }

    public void setExpirare(Date expirare) {
        this.expirare = expirare;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    @Override
    public String toString() {
        return "Produs{" +
                "tid=" + tid +
                ", nume='" + nume + '\'' +
                ", expirare=" + expirare +
                ", categorie=" + categorie +
                '}';
    }
}
