package hust.soict.hedspi.mclient.proxies;

import hust.soict.hedspi.mclient.beans.ProductBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="microservice-product", url="localhost:9001/api/products")
public interface MicroserviceProductProxy {

    @GetMapping
    List<ProductBean> getAllProduct();

    @GetMapping("/{id}")
    ProductBean getProductById(@PathVariable Long id);
}
