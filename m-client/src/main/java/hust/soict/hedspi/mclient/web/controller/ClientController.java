package hust.soict.hedspi.mclient.web.controller;

import hust.soict.hedspi.mclient.beans.ProductBean;
import hust.soict.hedspi.mclient.proxies.MicroserviceProductProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ClientController {

    @Autowired
    private MicroserviceProductProxy productProxy;

    @RequestMapping("/")
    public String index(Model model) {
        List<ProductBean> productBeans = this.productProxy.getAllProduct();

        model.addAttribute("products", productBeans);

        return "index";
    }
}
