package hust.soict.hedspi.morder.service;

import hust.soict.hedspi.morder.model.Order;
import hust.soict.hedspi.morder.repository.OrderRepository;
import hust.soict.hedspi.morder.web.exception.OrderNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    public Order createOrder(Order order) {
        return this.repository.save(order);
    }

    public Order getOrderById(Long id) throws OrderNotFoundException {
        Optional<Order> orderData = this.repository.findById(id);

        if (orderData.isEmpty()) {
            throw new OrderNotFoundException("Order has id: " + id + " was not found");
        }

        return orderData.get();
    }

    public List<Order> getAllOrder() {
        return this.repository.findAll();
    }
}
