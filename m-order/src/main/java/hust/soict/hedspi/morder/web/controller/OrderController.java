package hust.soict.hedspi.morder.web.controller;

import hust.soict.hedspi.morder.model.Order;
import hust.soict.hedspi.morder.service.OrderService;
import hust.soict.hedspi.morder.web.exception.OrderNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/orders")
public class OrderController {

    @Autowired
    private OrderService service;

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        try {
            Order _order = this.service.createOrder(order);
            return new ResponseEntity<>(_order, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
        try {
            Order order = this.service.getOrderById(id);
            return new ResponseEntity<>(order, HttpStatus.OK);
        } catch (OrderNotFoundException onfe) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrder() {
        try {
            List<Order> orders = this.service.getAllOrder();
            return orders.isEmpty() ?
                    new ResponseEntity<>(null, HttpStatus.NO_CONTENT) :
                    new ResponseEntity<>(orders, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
