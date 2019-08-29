package lsis.com.cpy.customer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@EnableCircuitBreaker
@EnableEurekaClient
@SpringBootApplication
public class CustomerApplication {
    public static void main(String... args) {
        SpringApplication.run(CustomerApplication.class, args);
    }
}
