package lsis.com.cpy.customer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ClientConfiguration {

    @Value("${orders.url}")
    String ordersUrl;

    @Bean
    public RestOperations restOperations() {
        return new RestTemplate();
    }

    @Bean
    public OrdersClient ordersClient(RestOperations restOperations) {
        return new OrdersClient(ordersUrl, restOperations);
    }
}
