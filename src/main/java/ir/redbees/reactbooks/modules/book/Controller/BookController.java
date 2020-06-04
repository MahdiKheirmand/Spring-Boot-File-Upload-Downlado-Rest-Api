package ir.redbees.reactbooks.modules.book.Controller;


import ir.redbees.reactbooks.modules.book.Entity.Book;
import ir.redbees.reactbooks.modules.book.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/register")
    public Book registerBook(@ModelAttribute Book book){
        return bookService.registerBook(book);
    }

    @GetMapping("/getall")
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    @DeleteMapping("/delete/{id}")
    public List<Book> deleteBook(@PathVariable  Long id) {
        return bookService.deleteBook(id);
    }

    @GetMapping("/{id}")
    public Book getBook(@PathVariable Long bookId){
        return bookService.findById(bookId);
    }


    @GetMapping("/file/{id}")
    public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable("id") Long id) {
        // Load file from database
        return bookService.downloadFile(id);
    }



    @RequestMapping
    public String start() {
        return "Welcome to Red Bees";
    }

}
