package hust.soict.hedspi.mpayment.proxies;

import hust.soict.hedspi.mpayment.beans.OrderBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="microservice-order", url="localhost:9002/api/orders")
public interface MicroserviceOrderProxy {

    @PostMapping
    OrderBean createOrder(@RequestBody OrderBean orderBean);

    @GetMapping("/{id}")
    OrderBean getOrderById(@PathVariable Long id);
}
