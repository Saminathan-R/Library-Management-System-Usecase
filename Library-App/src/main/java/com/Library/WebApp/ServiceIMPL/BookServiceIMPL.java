package com.Library.WebApp.ServiceIMPL;

import java.util.List;
import org.springframework.stereotype.Service;
import com.Library.WebApp.Exception.ResourceNotFoundException;
import com.Library.WebApp.Model.Book;
import com.Library.WebApp.Repository.BookRepository;
import com.Library.WebApp.Service.BookService;
@Service
public class BookServiceIMPL implements BookService{
    private BookRepository bookRepository ;
    
	public BookServiceIMPL(BookRepository bookRepository) {
		super();
		this.bookRepository = bookRepository;
	}

	@Override
	public List<Book> getAllbooks() {
		// TODO Auto-generated method stub
		return bookRepository.findAll();
	}

	@Override
	public Book getbookbyId(long id) {
		// TODO Auto-generated method stub
		return bookRepository.findById(id).orElseThrow( 
				()-> new ResourceNotFoundException("Book", "Id", id));
	}

	@Override
	public Book savebook(Book book) {
		// TODO Auto-generated method stub
		return bookRepository.save(book);
	}

	@Override
	public Book updateBook(Book book, long id) {
		{
	        Book existingBook = bookRepository.findById(id).orElseThrow (
	                () -> new ResourceNotFoundException ("Book" , "BookId" , id));
	        
	        existingBook.setId(book.getId());
	        existingBook.setTitle(book.getTitle());
	        existingBook.setAuthor(book.getAuthor());
	        existingBook.setRating(book.getRating());
	        existingBook.setIsbn(book.getIsbn());
	        bookRepository.save(existingBook);
	        return existingBook;
	        
	        }
	}
	@Override
	public void deleteBook(long id) 
		{
			bookRepository.findById(id).orElseThrow (() -> new ResourceNotFoundException ("Member" , "Id" , id));
			bookRepository.deleteById(id);		
		}
}
