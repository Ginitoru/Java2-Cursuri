package db;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Curs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ind;

    private String nume;

    @ManyToMany
    @JoinTable(
                name = "tabela_de_legatura",
                joinColumns = @JoinColumn (name = "joinColumnA"),
                inverseJoinColumns = @JoinColumn(name = "inverse_joinColumnB")
    )

    private Collection<Student> studenti;

    public int getInd() {
        return ind;
    }

    public void setInd(int ind) {
        this.ind = ind;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public Collection<Student> getStudenti() {
        return studenti;
    }

    public void setStudenti(Collection<Student> studenti) {
        this.studenti = studenti;
    }
}


