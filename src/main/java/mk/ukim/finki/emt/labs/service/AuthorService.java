package mk.ukim.finki.emt.labs.service;

import mk.ukim.finki.emt.labs.model.Author;
import mk.ukim.finki.emt.labs.model.Country;
import mk.ukim.finki.emt.labs.model.dto.AuthorDto;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    List<Author> findAll();
    Optional<Author> findById(Long author_id);

    Optional<Author> saveDto (AuthorDto authorDto);

    Optional<Author> editDto (Long author_id, AuthorDto authorDto);

    void deleteById(Long author_id);

}
