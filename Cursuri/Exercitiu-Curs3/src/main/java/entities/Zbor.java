package entities;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "zboruri")
public class Zbor {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;

    @Column(name = "locatei_plecare")
    private String plecare;

    @Column(name = "locatie_sosire")
    private String sosire;

    private LocalDateTime oraplecare;

    private LocalDateTime orasosire;

    @Embedded
    @AttributeOverride(name = "numeAvion", column = @Column(name = "nume_avion_smecher"))
    @AttributeOverride(name = "tipAvion", column = @Column(name = "tip_Avion"))
    private Avion avion;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlecare() {
        return plecare;
    }

    public void setPlecare(String plecare) {
        this.plecare = plecare;
    }

    public String getSosire() {
        return sosire;
    }

    public void setSosire(String sosire) {
        this.sosire = sosire;
    }

    public LocalDateTime getOraplecare() {
        return oraplecare;
    }

    public void setOraplecare(LocalDateTime oraplecare) {
        this.oraplecare = oraplecare;
    }

    public LocalDateTime getOrasosire() {
        return orasosire;
    }

    public void setOrasosire(LocalDateTime orasosire) {
        this.orasosire = orasosire;
    }

    public Avion getAvion() {
        return avion;
    }

    public void setAvion(Avion avion) {
        this.avion = avion;
    }
}
