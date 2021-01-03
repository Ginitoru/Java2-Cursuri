package db;

import javax.persistence.*;

@Entity
public class Profesor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nume;

    @ManyToOne
    private Scoala scoala;

    public Profesor() {
    }

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

    public Scoala getScoala() {
        return scoala;
    }

    public void setScoala(Scoala scoala) {
        this.scoala = scoala;
    }
}
