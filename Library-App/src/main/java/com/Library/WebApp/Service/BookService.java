package com.Library.WebApp.Service;

import java.util.List;

import com.Library.WebApp.Model.Book;

public interface BookService {

	List<Book> getAllbooks();
    Book getbookbyId(long id);
    Book savebook(Book book);
    Book updateBook(Book book , long id);
    void deleteBook(long id);
}
