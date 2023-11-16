package br.edu.ifpb.pdist.graphqlexample.repository;

import br.edu.ifpb.pdist.graphqlexample.model.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
}
