package br.edu.ifpb.pdist.graphqlexample.controller.graphqlcontroller;

import br.edu.ifpb.pdist.graphqlexample.model.ProductEntity;
import br.edu.ifpb.pdist.graphqlexample.model.ProductInput;
import br.edu.ifpb.pdist.graphqlexample.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.math.BigDecimal;
import java.util.UUID;

@Controller
@AllArgsConstructor
public class ProductGraphQLController {

    private ProductRepository productRepository;

    @MutationMapping
    ProductEntity addProduct(@Argument ProductInput product) {
        return this.productRepository.save(new ProductEntity(product.name(), product.price(), product.categoryId()));
    }

    @QueryMapping
    Iterable<ProductEntity> products() {
        return productRepository.findAll();
    }

    @QueryMapping
    Iterable<ProductEntity> productsByExample(@Argument ProductInput product) {
        final var exampleMatcher = ExampleMatcher.matching().withIgnoreNullValues();
        return productRepository.findAll(Example.of(new ProductEntity(product.name(), product.price(), product.categoryId()), exampleMatcher));
    }
}
