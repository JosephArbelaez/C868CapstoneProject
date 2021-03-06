package com.example.C868CapstoneProject.Controller;

import com.example.C868CapstoneProject.Service.BookService;
import com.example.C868CapstoneProject.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/book")
@CrossOrigin("*")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getBooks() {
        return bookService.getBooks();
    }

    @GetMapping(path = "/search/{query}")
    public List<Book> getBooks(@PathVariable("query") String query) {
    	return bookService.searchBooks(query);
    }

    @GetMapping(path = "/genre/{genre}")
    public List<Book> getBooksByGenre(@PathVariable("genre") String genre) {
        return bookService.getBooksByGenre(genre);
    }

    @GetMapping(path = "checked")
    public List<Book> getCheckedBooks() {
    	return bookService.getCheckedBooks();
    }

    @GetMapping(path = "unchecked")
    public List<Book> getUncheckedBooks() {
    	return bookService.getUncheckedBooks();
    }

    @PostMapping
    public void postBook(@RequestBody Book book) {
    	bookService.postBook(book);
    }

    @PutMapping
    public void updateBook(@RequestBody Book book) {
        bookService.updateBook(book);
    }

    @PutMapping(path = "checkin")
    public void checkInBook(@RequestBody Book book) {
        bookService.checkInBook(book);
    }

    @PutMapping(path = "reserve/{userID}/{isbn}")
    public void reserveBook(@PathVariable Long userID, @PathVariable Long isbn) {
        bookService.reserveBook(userID, isbn);
    }

    @DeleteMapping(path = "{isbn}")
    public void deleteBook(@PathVariable("isbn") Long isbn) {
        bookService.deleteBook(isbn);
    }

}
