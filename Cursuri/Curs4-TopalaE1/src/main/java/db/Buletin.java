package db;

import javax.persistence.*;

@Entity
public class Buletin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private String cod;

    //spunem ca nu buletin este owner-ul relatiei ci Persoana
    //valoarea lui mappedBy este numele atributului din clasa Persoana care mapeaza relatia
    @OneToOne(mappedBy = "buletin")
    private Persoana persoana;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public Persoana getPersoana() {
        return persoana;
    }

    public void setPersoana(Persoana persoana) {
        this.persoana = persoana;
    }
}
