package db;

import javax.persistence.*;

@Entity
public class Transmisie {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;

    private String mesaj;

    @Enumerated(EnumType.STRING)
    private TipTransmisie transmisie;

    public int getId() {
        return id;
    }


    public TipTransmisie getTransmisie() {
        return transmisie;
    }

    public void setTransmisie(TipTransmisie transmisie) {
        this.transmisie = transmisie;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMesaj() {
        return mesaj;
    }

    public void setMesaj(String mesaj) {
        this.mesaj = mesaj;
    }
}
