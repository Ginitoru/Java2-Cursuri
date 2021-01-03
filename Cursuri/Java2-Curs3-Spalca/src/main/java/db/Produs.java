package db;


import javax.persistence.*;

@Entity
@Table(name ="produse")
public class Produs {

    @Id
    @Column(name = "produs_id")
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;


    private String nume;
    private double pret;

    @Basic(optional = true)
    private String solutie;

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

    public double getPret() {
        return pret;
    }

    public void setPret(double pret) {
        this.pret = pret;
    }

    @Override
    public String toString() {
        return "Produs{" +
                "id=" + id +
                ", nume='" + nume + '\'' +
                ", pret=" + pret +
                '}';
    }
}
