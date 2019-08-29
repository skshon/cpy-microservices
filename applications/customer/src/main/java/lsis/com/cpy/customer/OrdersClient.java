package lsis.com.cpy.customer;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.client.RestOperations;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static org.springframework.http.HttpMethod.GET;

public class OrdersClient {

    private String orderUrl;
    private RestOperations restOperations;
    private Map<Long, List<OrderInfo>> ordersCache = new ConcurrentHashMap<>();

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

    @HystrixCommand(fallbackMethod = "getOrdersFromCache")
    public List<OrderInfo> getOrdersByCustomerId(long customerId) {
        ParameterizedTypeReference<List<OrderInfo>> albumListType = new ParameterizedTypeReference<List<OrderInfo>>() {
        };

        List<OrderInfo> orders = restOperations.exchange(orderUrl + "/customer/" + customerId, GET, null, albumListType).getBody();
        ordersCache.put(customerId, orders);

        return orders;
    }

    public List<OrderInfo> getOrdersFromCache(long customerId) {
        return ordersCache.get(customerId);
    }
}