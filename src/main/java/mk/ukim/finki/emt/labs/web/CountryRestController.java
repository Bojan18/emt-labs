package mk.ukim.finki.emt.labs.web;

import mk.ukim.finki.emt.labs.model.Country;
import mk.ukim.finki.emt.labs.model.dto.CountryDto;
import mk.ukim.finki.emt.labs.repository.CountryRepository;
import mk.ukim.finki.emt.labs.service.CountryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3001"})
@RequestMapping("/api/countries")
public class CountryRestController {
    private final CountryRepository countryRepository;
    private final CountryService countryService;

    public CountryRestController(CountryRepository countryRepository, CountryService countryService) {
        this.countryRepository = countryRepository;
        this.countryService = countryService;
    }

    @GetMapping
    private List<Country> findAll() {
        return countryRepository.findAll();
    }
    @GetMapping("/{id}")
    private ResponseEntity<Country> findById(@PathVariable Long id) {
        return countryRepository.findById(id)
                .map(country -> ResponseEntity.ok().body(country))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }
    @PostMapping("/add")
    private ResponseEntity<Country> save(@RequestBody CountryDto countryDto) {
        return countryService.saveDto(countryDto)
                .map(country -> ResponseEntity.ok().body(country))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }
    @PutMapping("/edit/{id}")
    private ResponseEntity<Country> save(@PathVariable Long id, @RequestBody CountryDto countryDto) {
        return countryService.editDto(id, countryDto)
                .map(country -> ResponseEntity.ok().body(country))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }
    @DeleteMapping("/delete/{id}")
    private ResponseEntity delete(@PathVariable Long id){
        countryService.deleteById(id);
        if(countryService.findById(id).isEmpty()){
            return ResponseEntity.ok().build();
        } else return ResponseEntity.badRequest().build();
    }
}
