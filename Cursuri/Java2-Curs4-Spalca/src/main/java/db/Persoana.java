package db;

import javax.persistence.*;

@Entity
public class Persoana {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nume;

    @OneToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE})
    @JoinColumn(name = "cardAcces_id_facut")
    private CardAcces cardAcces;

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

    public CardAcces getCardAcces() {
        return cardAcces;
    }

    public void setCardAcces(CardAcces cardAcces) {
        this.cardAcces = cardAcces;
    }
}
