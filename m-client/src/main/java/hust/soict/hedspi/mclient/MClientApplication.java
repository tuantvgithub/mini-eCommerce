package hust.soict.hedspi.mclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("hust.soict.hedspi.mclient.proxies")
public class MClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(MClientApplication.class, args);
	}

}
