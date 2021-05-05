package hust.soict.hedspi.mpayment.service;

import hust.soict.hedspi.mpayment.model.Payment;
import hust.soict.hedspi.mpayment.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository repository;

    public Payment findPaymentByIdOrder(Long orderId) {
        return this.repository.findByOrderId(orderId);
    }

    public Payment createPayment(Payment payment) {
        return this.repository.save(payment);
    }
}
