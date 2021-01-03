package db;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "tabela_produse")
public class Produs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "coloana_nume")
    private String nume;


    //in cazul claselor in java.time nu mai este necesare folosirea lui @Temporal
    //deoarece JPA stie deja ce fel de data sa mapeze
    private LocalDateTime dataProducere;

    //cand folsim java util date trebuie sa precizam ce fel de data reprezinta prin adnotarea
    //@Temporal
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataExpirare;

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

    @Override
    public String toString() {
        return "Produs{" +
                "id=" + id +
                ", nume='" + nume + '\'' +
                '}';
    }

    public Date getDataExpirare() {
        return dataExpirare;
    }

    public void setDataExpirare(Date dataExpirare) {
        this.dataExpirare = dataExpirare;
    }

    public LocalDateTime getDataProducere() {
        return dataProducere;
    }

    public void setDataProducere(LocalDateTime dataProducere) {
        this.dataProducere = dataProducere;
    }
}
