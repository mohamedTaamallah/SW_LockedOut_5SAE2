package lockedout.sae.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}

	@Bean
	public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
		return builder.routes()
				.route("costs", r -> r.path("/costs/**")
						.uri("http://cost:8075/"))
				.route("vehicles", r -> r.path("/vehicles/**")
						.uri("http://vehicle:8076/"))
				.route("trips", r -> r.path("/trips/**")
						.uri("http://trip:8077/"))
				.route("documents", r -> r.path("/documents/**")
						.uri("http://document:8078/"))
				.route("maintenances", r -> r.path("/maintenances/**")
						.uri("http://maintenance:8079/"))
				.build();
	}
}
