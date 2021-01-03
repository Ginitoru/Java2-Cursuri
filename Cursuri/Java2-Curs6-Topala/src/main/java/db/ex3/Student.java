package db.ex3;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name ="Student.findaAll", query = "SELECT s FROM Student s")
@NamedQuery(name ="Student.findByNume", query = "SELECT s FROM Student s WHERE s.id.nume = :nume")
public class Student {

    @EmbeddedId
    private NumePrenumeId id;

    private String cod;


    public NumePrenumeId getId() {
        return id;
    }

    public void setId(NumePrenumeId id) {
        this.id = id;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }



    @Override
    public String toString() {
        return id.getNume() + " " + id.getPrenume();
    }
}
