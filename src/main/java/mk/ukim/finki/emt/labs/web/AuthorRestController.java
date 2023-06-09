package mk.ukim.finki.emt.labs.web;

import mk.ukim.finki.emt.labs.model.Author;
import mk.ukim.finki.emt.labs.model.Book;
import mk.ukim.finki.emt.labs.model.dto.AuthorDto;
import mk.ukim.finki.emt.labs.model.dto.BookDto;
import mk.ukim.finki.emt.labs.repository.AuthorRepository;
import mk.ukim.finki.emt.labs.service.AuthorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3001"})
@RequestMapping("/api/authors")
public class AuthorRestController {
    private final AuthorRepository authorRepository;
    private final AuthorService authorService;

    public AuthorRestController(AuthorRepository authorRepository, AuthorService authorService) {
        this.authorRepository = authorRepository;
        this.authorService = authorService;
    }
    @GetMapping
    private List<Author> findAll(){
        return authorRepository.findAll();
    }
    @GetMapping("/{id}")
    private ResponseEntity<Author> findById(@PathVariable Long id){
        return authorRepository.findById(id)
                .map(author -> ResponseEntity.ok().body(author))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }
    @PostMapping("/add")
    private ResponseEntity<Author> save(@RequestBody AuthorDto authorDto){
        return authorService.saveDto(authorDto)
                .map(author -> ResponseEntity.ok().body(author))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }
    @PutMapping("/edit/{id}")
    private ResponseEntity<Author> edit(@PathVariable Long id, @RequestBody AuthorDto authorDto){
        return authorService.editDto(id, authorDto)
                .map(author -> ResponseEntity.ok().body(author))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }
    @DeleteMapping("/delete/{id}")
    private ResponseEntity delete(@PathVariable Long id){
        authorService.deleteById(id);
        if(authorService.findById(id).isEmpty()){
            return ResponseEntity.ok().build();
        } else return ResponseEntity.badRequest().build();
    }

}
