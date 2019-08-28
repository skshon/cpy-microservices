package lsis.com.cpy.customer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@SpringBootApplication
public class CustomerApplication {
    public static void main(String... args) {
        SpringApplication.run(CustomerApplication.class, args);
    }
}
