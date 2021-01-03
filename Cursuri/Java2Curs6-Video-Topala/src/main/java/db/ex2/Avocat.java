package db.ex2;

import javax.persistence.Entity;

@Entity
public class Avocat extends Anagajat{

    private int vechime;

    public int getVechime() {
        return vechime;
    }

    public void setVechime(int vechime) {
        this.vechime = vechime;
    }
}
