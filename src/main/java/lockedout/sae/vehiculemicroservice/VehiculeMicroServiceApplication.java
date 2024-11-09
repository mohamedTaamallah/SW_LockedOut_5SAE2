package lockedout.sae.vehiculemicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients
public class VehiculeMicroServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(VehiculeMicroServiceApplication.class, args);
    }

}
