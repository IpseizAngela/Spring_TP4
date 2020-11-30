package com.masteril.book.web.controller;

import com.masteril.book.dao.IBookDAO;
import com.masteril.book.model.Book;
import com.masteril.book.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookRepository dao;

    @GetMapping(value="/Books")
    public Iterable<Book> getBooks() {
        return dao.findAll();
    }

    @GetMapping(value="/Books/{id}")
    public Book getBook(@PathVariable int id) {
        return dao.findById(id);
    }

    @PostMapping(value="/Books")
    public void addBook(@RequestBody Book b) {
        dao.save(b);
    }

    @PutMapping(value="/Books/{id}")
    public void updateBook(@RequestBody Book newBook, @PathVariable int id) {
        Book book = dao.findById(id);
        if (newBook.getTitle() != null) {
            if (!newBook.getTitle().trim().equals(""))
                book.setTitle(newBook.getTitle());
        }
        if (newBook.getAuthor() != null) {
            if (!newBook.getAuthor().trim().equals(""))
                book.setTitle(newBook.getAuthor());
        }
        if (newBook.getDescription() != null) {
            if (!newBook.getDescription().trim().equals(""))
                book.setTitle(newBook.getDescription());
        }
        if (newBook.getPrice() > 0) {
            book.setTitle(newBook.getDescription());
        }
        dao.save(book);
    }

    @DeleteMapping(value="/Books/{id}")
    public void deleteBook(@PathVariable int id) { dao.deleteById(id); }
}
