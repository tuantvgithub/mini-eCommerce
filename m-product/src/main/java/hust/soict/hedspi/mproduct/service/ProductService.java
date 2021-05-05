package hust.soict.hedspi.mproduct.service;

import hust.soict.hedspi.mproduct.model.Product;
import hust.soict.hedspi.mproduct.repository.ProductRepository;
import hust.soict.hedspi.mproduct.web.exception.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public Product createProduct(Product product) {
        return this.repository.save(product);
    }

    public List<Product> getAllProduct() {
        return this.repository.findAll();
    }

    public Product getProductById(Long id) throws ProductNotFoundException {
        Optional<Product> productData = this.repository.findById(id);

        if (productData.isEmpty()) {
            throw new ProductNotFoundException("Product has id : " + id + " was not found");
        }

        return productData.get();
    }
}
