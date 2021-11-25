package com.booklibrary.controller;

import com.booklibrary.entity.Book;
import com.booklibrary.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path= "api/v1/library")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/addbook")
    public Book addBook(@RequestBody Book book){
        return bookService.saveBook(book);
    }

    @PostMapping("/addbooks")
    public List<Book> addBooks(@RequestBody List<Book> books){
        return bookService.saveBooks(books);
    }

    @GetMapping("/books")
    public List<Book> findAllBooks(){
        return bookService.getBooks();
    }

    @GetMapping("/book/{bookId}")
    public Book findBook(@PathVariable long bookId){
        return bookService.getBooksByID(bookId);
    }

    @GetMapping("/book/name/{bookName}")
    public Book findBookByName(@PathVariable String bookName){
        return bookService.getBookByName(bookName);
    }

    @PutMapping("/update")
    public Book updateBook(@RequestBody Book book){
        return bookService.updateBook(book);
    }

    @PutMapping("/lend")
    public Book lendBook(@RequestBody Book book){
        return bookService.lendBook(book);
    }

    @PutMapping("/return")
    public Book returnBook(@RequestBody Book book){
        return bookService.returnBook(book);
    }

    @DeleteMapping("/delete/{bookId}")
    public void deleteBook(@PathVariable long bookId){
        bookService.deleteBook(bookId);
    }
}
