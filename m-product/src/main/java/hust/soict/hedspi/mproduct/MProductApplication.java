package hust.soict.hedspi.mproduct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(MProductApplication.class, args);
	}

}
