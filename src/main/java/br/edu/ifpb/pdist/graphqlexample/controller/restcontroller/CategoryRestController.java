package br.edu.ifpb.pdist.graphqlexample.controller.restcontroller;

import br.edu.ifpb.pdist.graphqlexample.model.CategoryEntity;
import br.edu.ifpb.pdist.graphqlexample.model.CategoryInput;
import br.edu.ifpb.pdist.graphqlexample.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/categories")
@AllArgsConstructor
public class CategoryRestController {

    private CategoryRepository categoryRepository;

    @PostMapping
    CategoryEntity addCategory(@RequestBody CategoryInput category) {
        return categoryRepository.save(new CategoryEntity(category.name()));
    }

    @GetMapping("/{id}")
    Optional<CategoryEntity> categoryById(@PathVariable Long id) {
        return categoryRepository.findById(id);
    }

    @GetMapping
    Iterable<CategoryEntity> categories() {
        return categoryRepository.findAll();
    }

}
