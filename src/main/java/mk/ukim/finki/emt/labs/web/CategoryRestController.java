package mk.ukim.finki.emt.labs.web;

import mk.ukim.finki.emt.labs.enumerations.Category;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3001"})
@RequestMapping("/api/categories")
public class CategoryRestController {
    @GetMapping
    private ResponseEntity<Category[]> findAll(){
        return ResponseEntity.ok(Category.values());
    }
}
