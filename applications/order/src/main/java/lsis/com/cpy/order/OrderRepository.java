package lsis.com.cpy.order;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import java.util.List;

@Repository
public class OrderRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void addOrder(Order order) {
        entityManager.persist(order);
    }

    public Order find(long id) {
        return entityManager.find(Order.class, id);
    }

    public List<Order> getOrders() {
        CriteriaQuery<Order> cq = entityManager.getCriteriaBuilder().createQuery(Order.class);
        cq.select(cq.from(Order.class));
        return entityManager.createQuery(cq).getResultList();
    }

    public List<Order> getOrdersByCustomerId(long customId) {
        CriteriaQuery<Order> cq = entityManager.getCriteriaBuilder().createQuery(Order.class);
        Predicate predicate = entityManager.getCriteriaBuilder().equal(cq.from(Order.class).get("customer_id"), customId);
        cq.where(predicate);

        return entityManager.createQuery(cq).getResultList();
    }

    @Transactional
    public void deleteOrder(Order order) {
        entityManager.remove(order);
    }

    @Transactional
    public void updateOrder(Order order) {
        entityManager.merge(order);
    }
}
