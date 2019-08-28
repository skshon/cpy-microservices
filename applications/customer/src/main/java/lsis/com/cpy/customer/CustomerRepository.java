package lsis.com.cpy.customer;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Repository
public class CustomerRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void addCustomer(Customer customer) {
        entityManager.persist(customer);
    }

    public Customer find(long id) {
        return entityManager.find(Customer.class, id);
    }

    public List<Customer> getCustomers() {
        CriteriaQuery<Customer> cq = entityManager.getCriteriaBuilder().createQuery(Customer.class);
        cq.select(cq.from(Customer.class));
        return entityManager.createQuery(cq).getResultList();
    }

    @Transactional
    public void deleteCustomer(Customer customer) {
        entityManager.remove(customer);
    }

    @Transactional
    public void updateCustomer(Customer customer) {
        entityManager.merge(customer);
    }
}
