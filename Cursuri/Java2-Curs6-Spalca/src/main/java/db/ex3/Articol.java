package db.ex3;

import javax.persistence.Entity;

@Entity
public class Articol extends Publicatie {

    private String revista;

    public String getRevista() {
        return revista;
    }

    public void setRevista(String revista) {
        this.revista = revista;
    }
}
