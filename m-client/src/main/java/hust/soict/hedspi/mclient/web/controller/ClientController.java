package hust.soict.hedspi.mclient.web.controller;

import hust.soict.hedspi.mclient.beans.OrderBean;
import hust.soict.hedspi.mclient.beans.PaymentBean;
import hust.soict.hedspi.mclient.beans.ProductBean;
import hust.soict.hedspi.mclient.proxies.MicroserviceOrderProxy;
import hust.soict.hedspi.mclient.proxies.MicroservicePaymentProxy;
import hust.soict.hedspi.mclient.proxies.MicroserviceProductProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

@Controller
public class ClientController {

    @Autowired
    private MicroserviceProductProxy productProxy;

    @Autowired
    private MicroserviceOrderProxy orderProxy;

    @Autowired
    private MicroservicePaymentProxy paymentProxy;

    @RequestMapping("/")
    public String index(Model model) {
        List<ProductBean> productBeans = this.productProxy.getAllProduct();

        model.addAttribute("products", productBeans);

        return "index";
    }

    @RequestMapping("/product-detail/{id}")
    public String productDetail(@PathVariable Long id, Model model) {
        ProductBean productBean = this.productProxy.getProductById(id);

        model.addAttribute("product", productBean);

        return "product-detail";
    }

    @RequestMapping("/order/{productId}/{quantity}")
    public String orderProduct(@PathVariable Long productId,
                               @PathVariable Long quantity, Model model) {

        OrderBean orderBean = new OrderBean();

        orderBean.setDateOrder(new Date());
        orderBean.setProductId(productId);
        orderBean.setQuantity(quantity);
        orderBean.setPaid(false);

        OrderBean order = this.orderProxy.createOrder(orderBean);

        ProductBean productBean = this.productProxy.getProductById(productId);
        Long amount = quantity * productBean.getPrice();

        model.addAttribute("order", order);
        model.addAttribute("amount", amount);

        return "cart";
    }

    @RequestMapping("/pay-order/{orderId}/{amount}")
    public String payOrder(@PathVariable Long orderId, @PathVariable Long amount, Model model) {

        PaymentBean paymentBean = new PaymentBean();
        paymentBean.setOrderId(orderId);
        paymentBean.setAmount(amount);

        ResponseEntity<PaymentBean> payment = this.paymentProxy.createPayment(paymentBean);

        Boolean paid = false;
        if (payment.getStatusCode() == HttpStatus.CREATED) {
            paid = true;
        }

        model.addAttribute("paid", paid);

        return "confirmation";
    }
}
