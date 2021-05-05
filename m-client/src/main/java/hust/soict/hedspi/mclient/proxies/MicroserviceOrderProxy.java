package hust.soict.hedspi.mclient.proxies;

import hust.soict.hedspi.mclient.beans.OrderBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="microservice-order", url="localhost:9002/api/orders")
public interface MicroserviceOrderProxy {

    @PostMapping
    OrderBean createOrder(@RequestBody OrderBean orderBean);
}
