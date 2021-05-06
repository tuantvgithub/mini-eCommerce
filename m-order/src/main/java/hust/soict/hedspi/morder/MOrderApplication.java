package hust.soict.hedspi.morder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(MOrderApplication.class, args);
	}

}
