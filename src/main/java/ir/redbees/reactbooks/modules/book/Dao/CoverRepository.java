package ir.redbees.reactbooks.modules.book.Dao;

import ir.redbees.reactbooks.modules.book.Entity.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoverRepository extends JpaRepository<File, String> {
}
