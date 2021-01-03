package entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;

@Entity
public class Folder {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;

    private String numeFolder;

    private String autor;

    private boolean vizibil;

    private boolean accesCitier;

    private boolean accesScriere;

    @OneToMany(mappedBy = "folder", cascade = CascadeType.REMOVE)
    private Collection<Fisier> fisiere = new HashSet<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumeFolder() {
        return numeFolder;
    }

    public void setNumeFolder(String numeFolder) {
        this.numeFolder = numeFolder;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public boolean isVizibil() {
        return vizibil;
    }

    public void setVizibil(boolean vizibil) {
        this.vizibil = vizibil;
    }

    public boolean isAccesCitier() {
        return accesCitier;
    }

    public void setAccesCitier(boolean accesCitier) {
        this.accesCitier = accesCitier;
    }

    public boolean isAccesScriere() {
        return accesScriere;
    }

    public void setAccesScriere(boolean accesScriere) {
        this.accesScriere = accesScriere;
    }

    public Collection<Fisier> getFisiere() {
        return fisiere;
    }

    public void setFisiere(Collection<Fisier> fisiere) {
        this.fisiere = fisiere;
    }
}
