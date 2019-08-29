package lsis.com.cpy.customer;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.client.RestOperations;

import java.util.List;

import static org.springframework.http.HttpMethod.GET;

public class OrdersClient {

    private String orderUrl;
    private RestOperations restOperations;

    public OrdersClient(String orderUrl, RestOperations restOperations) {
        this.orderUrl = orderUrl;
        this.restOperations = restOperations;
    }

    public void addOrder(OrderInfo order) {
        restOperations.postForEntity(orderUrl, order, OrderInfo.class);
    }

    public OrderInfo find(long id) {
        return restOperations.getForEntity(orderUrl + "/" + id, OrderInfo.class).getBody();
    }

    public List<OrderInfo> getOrders() {
        ParameterizedTypeReference<List<OrderInfo>> albumListType = new ParameterizedTypeReference<List<OrderInfo>>() {
        };

        return restOperations.exchange(orderUrl, GET, null, albumListType).getBody();
    }

    public List<OrderInfo> getOrdersByCustomerId(long customerId) {
        ParameterizedTypeReference<List<OrderInfo>> albumListType = new ParameterizedTypeReference<List<OrderInfo>>() {
        };

        return restOperations.exchange(orderUrl + "/customer/" + customerId, GET, null, albumListType).getBody();
    }
}