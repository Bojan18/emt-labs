package mk.ukim.finki.emt.labs.service;

import mk.ukim.finki.emt.labs.enumerations.Condition;
import mk.ukim.finki.emt.labs.enumerations.RentalStatus;
import mk.ukim.finki.emt.labs.model.dto.BookDto;
import mk.ukim.finki.emt.labs.enumerations.Category;
import mk.ukim.finki.emt.labs.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> findAll();

    Optional<Book> findById(Long book_id);
    Optional<Book> findByName(String name);

    Optional<Book> save(String name, Category category, Long author_id, int availableCopies, RentalStatus rentalStatus, Condition condition);
    Optional<Book> saveDto(BookDto bookDto);

    Optional<Book> edit(Long book_id, String name, Category category, Long author_id, int availableCopies);

//    Optional<Book> rentBook(Long book_id);

    Optional<Book> rentBookDto(Long book_id, BookDto bookDto);

    Optional<Book> editDto(Long book_id, BookDto bookDto);

    Optional<Book> changeCondition(Long book_id, BookDto bookDto);

    void deleteById(Long book_id);

}
