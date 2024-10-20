package lockedout.sae.vehiculemicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class VehiculemicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(VehiculemicroserviceApplication.class, args);
	}

}
