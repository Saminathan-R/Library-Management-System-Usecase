package com.Library.WebApp.Controller;

import com.Library.WebApp.Model.Book;
import com.Library.WebApp.Service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin("*")
@RestController
    @RequestMapping("/book")
    public class BookController 
    {
    private BookService bookService ;
    
    public BookController(BookService libraryService) 
    {
		super();
		this.bookService = libraryService;
	}
    @GetMapping()
    public List<Book> getAllBooks(){
        return bookService.getAllbooks();
    }
    @GetMapping("{id}")
    public ResponseEntity<Book> getBookById (@PathVariable ("id") Long id) {
        return new ResponseEntity<Book> (bookService.getbookbyId(id), HttpStatus.OK);
    }
    @PostMapping()
    public ResponseEntity<Book> saveBook(@RequestBody Book member) {
        return new ResponseEntity<Book> (bookService.savebook(member), HttpStatus.CREATED);
    }
    @PutMapping ("{id}")
    public ResponseEntity<Book> updateBook(@PathVariable ("id") Long id , @RequestBody Book member) {
        return new ResponseEntity<Book> (bookService.updateBook(member, id), HttpStatus.OK);
    }
    @DeleteMapping ("{id}")
    public ResponseEntity<String> deleteBook(@PathVariable ("id") Long id) {
    	bookService.deleteBook(id);
        return new ResponseEntity <String> ("Book deleted" , HttpStatus.OK);
    }
}