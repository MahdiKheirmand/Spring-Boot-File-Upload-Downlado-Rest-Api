package ir.redbees.reactbooks.modules.book.Entity;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;

@Entity
@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String writer;
    private String summary;

    private String publisher;

    private double price;

    @OneToOne
    private File cover;


    @Transient
    @JsonIgnore
    private MultipartFile file;

    public Book() {

    }

    public Book(String title, String writer, String summery, String publisher, double price, MultipartFile file) {
        this.title = title;
        this.writer = writer;
        this.summary = summery;
        this.publisher = publisher;
        this.price = price;
        this.file = file;
    }
}
