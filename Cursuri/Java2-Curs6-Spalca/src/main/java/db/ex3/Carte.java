package db.ex3;

import javax.persistence.Entity;

@Entity
public class Carte extends Publicatie {

    private String isbn;

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
