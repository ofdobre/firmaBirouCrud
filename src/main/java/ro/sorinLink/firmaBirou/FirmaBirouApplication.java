package ro.sorinLink.firmaBirou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class FirmaBirouApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirmaBirouApplication.class, args);
	}

}
