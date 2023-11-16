package br.edu.ifpb.pdist.graphqlexample.repository;

import br.edu.ifpb.pdist.graphqlexample.model.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
}
