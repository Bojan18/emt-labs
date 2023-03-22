package mk.ukim.finki.emt.labs.service.Impl;

import mk.ukim.finki.emt.labs.exceptions.AuthorNotFoundException;
import mk.ukim.finki.emt.labs.exceptions.CountryNotFoundException;
import mk.ukim.finki.emt.labs.model.Author;
import mk.ukim.finki.emt.labs.model.Book;
import mk.ukim.finki.emt.labs.model.Country;
import mk.ukim.finki.emt.labs.model.dto.AuthorDto;
import mk.ukim.finki.emt.labs.repository.AuthorRepository;
import mk.ukim.finki.emt.labs.repository.BookRepository;
import mk.ukim.finki.emt.labs.repository.CountryRepository;
import mk.ukim.finki.emt.labs.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository,
                             CountryRepository countryRepository,
                             BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public Optional<Author> findById(Long author_id) {
        return authorRepository.findById(author_id);
    }

    @Override
    public Optional<Author> saveDto(AuthorDto authorDto) {
        Country country = countryRepository.findById(authorDto.getCountry().getCountry_id()).orElseThrow(CountryNotFoundException::new);

        Author author = new Author(authorDto.getName(), authorDto.getSurname(), country);

        authorRepository.save(author);
        return Optional.of(author);
    }

    @Override
    public Optional<Author> editDto(Long author_id, AuthorDto authorDto) {
        Author author = authorRepository.findById(author_id).orElseThrow(AuthorNotFoundException::new);
        Country country = countryRepository.findById(authorDto.getCountry().getCountry_id()).orElseThrow(CountryNotFoundException::new);

        author.setName(authorDto.getName());
        author.setSurname(authorDto.getSurname());
        author.setCountry(country);

        authorRepository.save(author);
        return Optional.of(author);
    }

    @Override
    public void deleteById(Long author_id) {
        authorRepository.deleteById(author_id);
    }
}
