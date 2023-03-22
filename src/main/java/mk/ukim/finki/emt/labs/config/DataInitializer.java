package mk.ukim.finki.emt.labs.config;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.emt.labs.enumerations.Category;
import mk.ukim.finki.emt.labs.enumerations.Condition;
import mk.ukim.finki.emt.labs.enumerations.RentalStatus;
import mk.ukim.finki.emt.labs.model.Author;
import mk.ukim.finki.emt.labs.model.Book;
import mk.ukim.finki.emt.labs.model.Country;
import mk.ukim.finki.emt.labs.repository.AuthorRepository;
import mk.ukim.finki.emt.labs.repository.BookRepository;
import mk.ukim.finki.emt.labs.repository.CountryRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataInitializer {
    private final CountryRepository countryRepository;
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public DataInitializer(CountryRepository countryRepository,
                           AuthorRepository authorRepository,
                           BookRepository bookRepository) {
        this.countryRepository = countryRepository;
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @PostConstruct
    public void init(){
        //country, author, book
        for (int i = 1; i <= 3; i++) {
            countryRepository.save(new Country("Country: " + i, "Continent: " + i));
            List<Country> countryList = countryRepository.findAll();
            authorRepository.save(new Author("AuthorName: " + i, "AuthorSurname: " + i, countryList.get(i-1)));
            List<Author> authorList = authorRepository.findAll();
            bookRepository.save(new Book("Book: " + i, Category.DRAMA, authorList.get(i-1), 3, RentalStatus.AVAILABLE, Condition.GOOD));
        }
        List<Country> countryList = countryRepository.findAll();
        authorRepository.save(new Author("AuthorName: " + 4, "AuthorSurname: " + 4, countryList.get(1)));
    }

}
