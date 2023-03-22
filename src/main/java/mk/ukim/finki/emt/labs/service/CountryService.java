package mk.ukim.finki.emt.labs.service;

import mk.ukim.finki.emt.labs.model.Author;
import mk.ukim.finki.emt.labs.model.Country;
import mk.ukim.finki.emt.labs.model.dto.AuthorDto;
import mk.ukim.finki.emt.labs.model.dto.CountryDto;

import java.util.List;
import java.util.Optional;

public interface CountryService {
    List<Country> findAll();
    Optional<Country> findById(Long country_id);

    Optional<Country> saveDto (CountryDto countryDto);

    Optional<Country> editDto (Long country_id, CountryDto countryDto);

    void deleteById(Long country_id);
}
