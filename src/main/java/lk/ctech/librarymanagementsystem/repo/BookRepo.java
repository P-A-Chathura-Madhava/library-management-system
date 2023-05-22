package lk.ctech.librarymanagementsystem.repo;

import lk.ctech.librarymanagementsystem.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepo extends MongoRepository<Book, Integer> {
}
