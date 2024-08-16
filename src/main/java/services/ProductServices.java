package services;

import model.Product;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repo.ProductRepository;

import java.util.List;


@Service
public class ProductServices {
    private final ProductRepository productRepository;

    @Autowired
    public ProductServices(ProductRepository productRepository){
        this.productRepository = productRepository;
    }


    public Product addProduct(Product product){
        return productRepository.save(product);
    }

    public List<Product> findAllProduct(){
        return productRepository.findAll();
    }

    public Product updateProduct(Product product){
        return productRepository.save(product);
    }

    public Product findProductById(Long id){
        return productRepository.findProductById(id);
    }


    @Transactional
    public void deleteProduct(Long id){
        productRepository.deleteProductById(id);
    }
}
