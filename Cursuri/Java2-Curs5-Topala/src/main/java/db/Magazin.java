package db;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
public class Magazin {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ind;

    //valoare map-ului va fi emailul contact ce formaeaza ellement coletion-ul


    @ElementCollection
    private Map<String, String> emails = new HashMap<>();


    public int getInd() {
        return ind;
    }

    public void setInd(int ind) {
        this.ind = ind;
    }

    public Map<String, String> getEmails() {
        return emails;
    }

    public void setEmails(Map<String, String> emails) {
        this.emails = emails;
    }
}
