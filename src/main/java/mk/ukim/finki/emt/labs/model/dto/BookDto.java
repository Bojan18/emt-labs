package mk.ukim.finki.emt.labs.model.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import mk.ukim.finki.emt.labs.enumerations.Category;
import mk.ukim.finki.emt.labs.enumerations.Condition;
import mk.ukim.finki.emt.labs.enumerations.RentalStatus;
import mk.ukim.finki.emt.labs.model.Author;

@Data
public class BookDto {

    private String name;
    private Category category;
    private Long author_id;
    private int availableCopies;
    private RentalStatus rentalStatus;
    private Condition condition;
    public BookDto() {
    }

    public BookDto(String name, Category category, Long author_id, int availableCopies, RentalStatus rentalStatus, Condition condition) {
        this.name = name;
        this.category = category;
        this.author_id = author_id;
        this.availableCopies = availableCopies;
        this.rentalStatus = rentalStatus;
        this.condition = condition;
    }

}
