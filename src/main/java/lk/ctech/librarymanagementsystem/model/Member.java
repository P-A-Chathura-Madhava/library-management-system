package lk.ctech.librarymanagementsystem.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document(collection = "Member")
public class Member {
    @Id
    private int memberId;
    private String title;
    private String year;
    private String author;
    private double price;
}
