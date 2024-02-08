package microservice.servicediscoveryserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
@EnableEurekaServer
public class ServiceDiscoveryServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceDiscoveryServerApplication.class, args);
	}

}
