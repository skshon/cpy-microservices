package lsis.com.cpy.customer;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrdersController {

    private final OrdersClient ordersClient;

    public OrdersController(OrdersClient ordersClient) {
        this.ordersClient = ordersClient;
    }

    @GetMapping
    public List<OrderInfo> index() {
        return ordersClient.getOrders();
    }

    @GetMapping("/{orderId}")
    public OrderInfo details(@PathVariable long orderId) {
        return ordersClient.find(orderId);
    }

    @GetMapping("/customer/{customerId}")
    public List<OrderInfo> indexByCustomerId(@PathVariable long customerId) {
        return ordersClient.getOrdersByCustomerId(customerId);
    }

    /*
    @GetMapping
    public String index(Map<String, Object> model) {
        model.put("orders", ordersClient.getOrders());
        return "orders";
    }

    @GetMapping("/{orderId}")
    public String details(@PathVariable long orderId, Map<String, Object> model) {
        model.put("order", ordersClient.find(orderId));
        return "orderDetails";
    }

    @GetMapping("/customer/{customerId}")
    public String indexByCustomerId(@PathVariable long customerId, Map<String, Object> model) {
        model.put("orders", ordersClient.getOrdersByCustomerId(customerId));
        return "orders";
    }
     */
}
