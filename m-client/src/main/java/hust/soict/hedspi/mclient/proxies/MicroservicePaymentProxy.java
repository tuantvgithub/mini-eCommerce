package hust.soict.hedspi.mclient.proxies;

import hust.soict.hedspi.mclient.beans.PaymentBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="microservice-payment", url="localhost:9003/api/payments")
public interface MicroservicePaymentProxy {

    @PostMapping
    ResponseEntity<PaymentBean> createPayment(@RequestBody PaymentBean paymentBean);
}
