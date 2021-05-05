package hust.soict.hedspi.mpayment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("hust.soict.hedspi.mpayment.proxies")
public class MPaymentApplication {

	public static void main(String[] args) {
		SpringApplication.run(MPaymentApplication.class, args);
	}

}
