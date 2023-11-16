package br.edu.ifpb.pdist.graphqlexample.controller.graphqlcontroller;

import br.edu.ifpb.pdist.graphqlexample.model.CategoryEntity;
import br.edu.ifpb.pdist.graphqlexample.model.CategoryInput;
import br.edu.ifpb.pdist.graphqlexample.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
@AllArgsConstructor
public class CategoryGraphQLController {

    private CategoryRepository categoryRepository;

    @MutationMapping
    CategoryEntity addCategory(@Argument CategoryInput category) {
        return categoryRepository.save(new CategoryEntity(category.name()));
    }

    @QueryMapping
    Optional<CategoryEntity> categoryById(@Argument Long id) {
        return categoryRepository.findById(id);
    }

    @QueryMapping
    Iterable<CategoryEntity> categories() {
        return categoryRepository.findAll();
    }

}
