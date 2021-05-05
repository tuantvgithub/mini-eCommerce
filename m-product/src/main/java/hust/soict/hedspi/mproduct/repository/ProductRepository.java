package hust.soict.hedspi.mproduct.repository;

import hust.soict.hedspi.mproduct.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product, Long> {

}
