package entiti.ex1;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Book extends Publication{



    @ManyToOne( cascade = CascadeType.PERSIST)
    private Publisher publisher;


    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(publisher, book.publisher);
    }

    @Override
    public int hashCode() {
        return Objects.hash(publisher);
    }

//    @Override
//    public String toString() {
//        return "Book{" +
//                "publisher=" + publisher +
//                '}';
//    }
}
