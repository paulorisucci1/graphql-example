package br.edu.ifpb.pdist.graphqlexample.controller.restcontroller;

import br.edu.ifpb.pdist.graphqlexample.model.ProductEntity;
import br.edu.ifpb.pdist.graphqlexample.model.ProductInput;
import br.edu.ifpb.pdist.graphqlexample.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductRestController {

    private ProductRepository productRepository;

    @PostMapping
    ProductEntity addProduct(@RequestBody ProductInput product) {
        return this.productRepository.save(new ProductEntity(product.name(), product.price(), product.categoryId()));
    }

    @GetMapping
    Iterable<ProductEntity> products() {
        return productRepository.findAll();
    }
}
