package lsis.com.cpy.order;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository) {

        this.orderRepository = orderRepository;
    }

    @PostMapping
    public void addCustomer(@RequestBody Order order) {

        orderRepository.addOrder(order);
    }

    @GetMapping
    public List<Order> index() {

        return orderRepository.getOrders();
    }

    @GetMapping("/customer/{customerId}")
    public List<Order> indexByCustomerId(@PathVariable long customerId) {
        return orderRepository.getOrdersByCustomerId(customerId);
    }

    @GetMapping("/{orderId}")
    public Order details(@PathVariable long orderId) {

        return orderRepository.find(orderId);
    }
}
