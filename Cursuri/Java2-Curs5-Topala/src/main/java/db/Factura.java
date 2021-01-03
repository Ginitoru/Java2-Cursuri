package db;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;

@Entity
public class Factura {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDate dataEmitere;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ElementCollection
    Collection<String> emails = new HashSet<>();

    @ManyToMany(mappedBy = "facturi")
    Collection<Produs> produs = new HashSet<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDataEmitere() {
        return dataEmitere;
    }

    public void setDataEmitere(LocalDate dataEmitere) {
        this.dataEmitere = dataEmitere;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Collection<String> getEmails() {
        return emails;
    }

    public void setEmails(Collection<String> emails) {
        this.emails = emails;
    }

    public Collection<Produs> getProdus() {
        return produs;
    }

    public void setProdus(Collection<Produs> produs) {
        this.produs = produs;
    }
}
