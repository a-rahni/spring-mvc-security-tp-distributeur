
package fr.m2i.spring.lesson.mvc.repository;

import fr.m2i.spring.lesson.mvc.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    
}
