package db;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Strudent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int serie;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "tabela_mea_DE_LEGATURA",
    joinColumns = @JoinColumn(name = "Stundet_id"), inverseJoinColumns = @JoinColumn(name = "Curs_id"))
    private Collection<Curs> cursuri;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSerie() {
        return serie;
    }

    public void setSerie(int serie) {
        this.serie = serie;
    }

    public Collection<Curs> getCursuri() {
        return cursuri;
    }

    public void setCursuri(Collection<Curs> cursuri) {
        this.cursuri = cursuri;
    }
}
