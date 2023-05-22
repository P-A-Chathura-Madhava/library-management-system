package lk.ctech.librarymanagementsystem.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document(collection = "IssueItem")
public class IssueItem {
    @Id
    private int issueId;
    private int memberId;
    private int bookId;
    private String date;
}
