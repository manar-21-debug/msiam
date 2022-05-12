package ma.bkam.msiam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class BkamApplication {

	public static void main(String[] args) {
		SpringApplication.run(BkamApplication.class, args);
	}

}
