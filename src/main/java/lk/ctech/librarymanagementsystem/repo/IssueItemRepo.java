package lk.ctech.librarymanagementsystem.repo;

import lk.ctech.librarymanagementsystem.model.IssueItem;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IssueItemRepo extends MongoRepository<IssueItem, Integer> {
}
