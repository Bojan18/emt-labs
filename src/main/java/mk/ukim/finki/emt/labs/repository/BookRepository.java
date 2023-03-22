package mk.ukim.finki.emt.labs.repository;

import mk.ukim.finki.emt.labs.model.Author;
import mk.ukim.finki.emt.labs.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findByName(String name);
    List<Book> findByAuthor(Author author);
    void deleteByName(String name);
}
