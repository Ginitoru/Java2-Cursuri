package db;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int serie;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "tabela_mea_de_legatua", joinColumns = @JoinColumn(name = "Curs_ID"),
            inverseJoinColumns = @JoinColumn(name = "STUDENT_ID"))
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
