package ir.redbees.reactbooks.modules.book.Service;


import ir.redbees.reactbooks.modules.book.Dao.BooksRepository;
import ir.redbees.reactbooks.modules.book.Dao.CoverRepository;
import ir.redbees.reactbooks.modules.book.Entity.Book;
import ir.redbees.reactbooks.modules.book.Entity.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final BooksRepository booksRepository;
    private final CoverRepository coverRepository;

    @Autowired
    public BookService(BooksRepository booksRepository, CoverRepository coverRepository) {
        this.booksRepository = booksRepository;
        this.coverRepository = coverRepository;
    }

    public Book registerBook(Book book) {
        book.setCover(createDBFile(book.getFile()));
        Book saved = booksRepository.save(book);
        return saved;
    }

    private File createDBFile(MultipartFile file) {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            if (fileName.contains("..")) {
                System.out.println("Error file name");
            }

            File cover = new File(fileName, file.getContentType(), file.getBytes());
            return coverRepository.save(cover);
        } catch (IOException ex) {
            System.out.println("Error file not found");
        }
        return null;
    }

    public List<Book> getAllBooks() {
        return booksRepository.findAll();
    }

    public List<Book> deleteBook(Long id) {
        booksRepository.deleteById(id);
        return booksRepository.findAll();
    }

    public Book findById(Long id) {
        Optional<Book> optionalBook = booksRepository.findById(id);
        return optionalBook.orElse(null);
    }

    public ResponseEntity<ByteArrayResource> downloadFile(Long bookID) {
        Book book = findById(bookID);

        if(book == null){
            return null;
        } else {
            File dbFile = book.getCover();

            return ResponseEntity.ok()
                    .contentType(MediaType.parseMediaType(dbFile.getFileType()))
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + dbFile.getFileName() + "\"")
                    .body(new ByteArrayResource(dbFile.getData()));
        }
    }
}
