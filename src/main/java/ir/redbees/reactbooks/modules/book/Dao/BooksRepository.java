package ir.redbees.reactbooks.modules.book.Dao;

import ir.redbees.reactbooks.modules.book.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BooksRepository extends JpaRepository<Book, Long> {
}
