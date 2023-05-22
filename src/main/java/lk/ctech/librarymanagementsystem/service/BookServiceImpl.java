package lk.ctech.librarymanagementsystem.service;

import lk.ctech.librarymanagementsystem.model.Book;
import lk.ctech.librarymanagementsystem.repo.BookRepo;
import lk.ctech.librarymanagementsystem.util.VarList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepo bookRepo;

    @Override
    public String saveBook(Book book) {
        if (bookRepo.existsById(book.getBookId())){
            return VarList.RSP_DUPLICATED;
        }else {
            bookRepo.save(book);
            return VarList.RSP_SUCCESS;
        }
    }

    @Override
    public String updateBook(Book book) {
        if (bookRepo.existsById(book.getBookId())){
            bookRepo.save(book);
            return VarList.RSP_SUCCESS;
        }else {
            return VarList.RSP_NO_DATA_FOUND;
        }
    }
}
