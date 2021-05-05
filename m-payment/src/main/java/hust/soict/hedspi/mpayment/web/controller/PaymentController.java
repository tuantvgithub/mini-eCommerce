package hust.soict.hedspi.mpayment.web.controller;

import hust.soict.hedspi.mpayment.beans.OrderBean;
import hust.soict.hedspi.mpayment.model.Payment;
import hust.soict.hedspi.mpayment.proxies.MicroserviceOrderProxy;
import hust.soict.hedspi.mpayment.service.PaymentService;
import hust.soict.hedspi.mpayment.web.exception.PaymentExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/payments")
public class PaymentController {

    @Autowired
    private PaymentService service;

    @Autowired
    private MicroserviceOrderProxy orderProxy;

    @PostMapping
    public ResponseEntity<Payment> payOrder(@RequestBody Payment payment) {
        try {
            Payment existsPayment = this.service.findPaymentByIdOrder(payment.getOrderId());
            if (existsPayment != null) {
                throw new PaymentExistsException("unable to establish payment, try again later");
            }

            Payment newPayment = this.service.createPayment(payment);

            OrderBean orderBean = this.orderProxy.getOrderById(newPayment.getOrderId());
            orderBean.setPaid(true);
            this.orderProxy.createOrder(orderBean);

            return new ResponseEntity<>(newPayment, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
