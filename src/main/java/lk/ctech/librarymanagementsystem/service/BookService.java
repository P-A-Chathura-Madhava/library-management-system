package lk.ctech.librarymanagementsystem.service;

import lk.ctech.librarymanagementsystem.model.Book;

public interface BookService {
    String saveBook(Book book);
    String updateBook(Book book);
}
