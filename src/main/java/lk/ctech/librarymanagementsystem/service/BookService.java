package lk.ctech.librarymanagementsystem.service;

import lk.ctech.librarymanagementsystem.model.Book;

import java.util.List;

public interface BookService {
    String saveBook(Book book);
    String updateBook(Book book);
    List<Book> getAllBooks();
    Book searchBookById(int id);
    String deleteBookById(int id);
}
