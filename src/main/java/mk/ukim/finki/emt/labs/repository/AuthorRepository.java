package mk.ukim.finki.emt.labs.repository;

import mk.ukim.finki.emt.labs.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
