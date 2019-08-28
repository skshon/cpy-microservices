package lsis.com.cpy.customer;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @PostMapping
    public void addCustomer(@RequestBody Customer customer) {
        customerRepository.addCustomer(customer);
    }

    @GetMapping
    public List<Customer> index() {
        return customerRepository.getCustomers();
    }

    @GetMapping("/{customerId}")
    public Customer details(@PathVariable long customerId) {
        return customerRepository.find(customerId);
    }
}
