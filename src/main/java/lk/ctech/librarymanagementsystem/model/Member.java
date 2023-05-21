package lk.ctech.librarymanagementsystem.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Builder
@Document(collection = "Member")
public class Member {
    @Id
    private int memberId;
    private String name;
    private String address;
    private String contact;
    private String dateJoined;
}
