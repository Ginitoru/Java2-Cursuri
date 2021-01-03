package db.ex7;

import javax.persistence.*;
import java.util.Collection;

@Entity
@NamedQueries({
        @NamedQuery(name = "Factura.getAll", query = "SELECT f FROM Factura f"),
        @NamedQuery(name = "Factura.getById", query = "SELECT f FROM Factura f WHERE f.id = :id")
})
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;


    private String serie;

    private int numar;

    @OneToMany(mappedBy = "factura")
    private Collection<LinieFactura> linii;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public int getNumar() {
        return numar;
    }

    public void setNumar(int numar) {
        this.numar = numar;
    }

    public Collection<LinieFactura> getLinii() {
        return linii;
    }

    public void setLinii(Collection<LinieFactura> linii) {
        this.linii = linii;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "id=" + id +
                ", serie='" + serie + '\'' +
                ", numar=" + numar +
                ", linii=" + linii +
                '}';
    }
}
