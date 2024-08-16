package repo;

import model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    void deleteProductById(Long id);

    Product findProductById(Long id);
}
