package mk.ukim.finki.emt.labs.model.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import mk.ukim.finki.emt.labs.model.Country;

@Data
public class AuthorDto {
    private Long author_id;
    private String name;
    private String surname;
    private Country country;

    public AuthorDto() {
    }

    public AuthorDto(String name, String surname, Country country) {
        this.name = name;
        this.surname = surname;
        this.country = country;
    }
}
