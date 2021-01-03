package entities;

import javax.persistence.*;

@Entity
public class Fisier {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;

    private String numeFisier;

    private String autor;

    private boolean accesCitire;

    private boolean accesScriere;

    @ManyToOne()
    private Folder folder;

    @Embedded
    private Rand rand;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumeFisier() {
        return numeFisier;
    }

    public void setNumeFisier(String numeFisier) {
        this.numeFisier = numeFisier;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public boolean isAccesCitire() {
        return accesCitire;
    }

    public void setAccesCitire(boolean accesCitire) {
        this.accesCitire = accesCitire;
    }

    public boolean isAccesScriere() {
        return accesScriere;
    }

    public void setAccesScriere(boolean accesScriere) {
        this.accesScriere = accesScriere;
    }

    public Folder getFolder() {
        return folder;
    }

    public void setFolder(Folder folder) {
        this.folder = folder;
    }

    public Rand getRand() {
        return rand;
    }

    public void setRand(Rand rand) {
        this.rand = rand;
    }
}
