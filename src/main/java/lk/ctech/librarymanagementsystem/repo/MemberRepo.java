package lk.ctech.librarymanagementsystem.repo;

import lk.ctech.librarymanagementsystem.model.Member;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepo extends MongoRepository<Member, Integer> {
}
