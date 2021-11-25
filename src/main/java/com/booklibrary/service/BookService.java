package com.booklibrary.service;

import com.booklibrary.entity.Book;
import com.booklibrary.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book saveBook(Book book){
      return  bookRepository.save(book);
    }

    public List<Book> saveBooks(List<Book> books){
        return  bookRepository.saveAll(books);
    }

    public Book getBooksByID(long bookId){
        return bookRepository.findById(bookId).orElse(null);
    }

    public Book getBookByName(String name){
        return bookRepository.findByName(name);
    }

    public List<Book> getBooks(){
        return bookRepository.findAll();
    }


    public void deleteBook(long bookId) {
        if (bookRepository.existsById(bookId)) {
            bookRepository.deleteById(bookId);
        } else {
            throw new IllegalStateException("Book with id does not exist");
        }

    }

    @Transactional
    public Book updateBook (Book book){
        Book existingBook = bookRepository.findById(book.getId()).orElse(null);
        if (existingBook != null){
            existingBook.setAuthor(book.getAuthor());
            existingBook.setYear(book.getYear());
            existingBook.setAvailableCopies(book.getAvailableCopies());
            existingBook.setName(book.getName());
            existingBook.setBorrowed(book.isBorrowed());
           return existingBook;
        } else {
            throw new IllegalStateException("Book does not exist");
        }
    }

    @Transactional
    public Book lendBook (Book book){
        Book existingBook = bookRepository.findByName(book.getName());
        if (existingBook != null){
            existingBook.setBorrowed(true);
            return existingBook;
        } else {
            throw new IllegalStateException("Book does not exist");
        }
    }

    @Transactional
    public Book returnBook (Book book){
        Book existingBook = bookRepository.findByName(book.getName());
        if (existingBook != null){
            existingBook.setBorrowed(false);
            return existingBook;
        } else {
            throw new IllegalStateException("Book does not exist");
        }
    }
}
