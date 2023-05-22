package lk.ctech.librarymanagementsystem.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document(collection = "Book")
public class Book {
    @Id
    private int bookId;
    private String title;
    private String author;
    private double price;
    private String year;
}
