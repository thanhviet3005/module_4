package managing_customer_2.repository;

import managing_customer_2.model.Customer;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;
@Repository
@Transactional
public class CustomerRepositoryImpl implements CustomerRepository{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Customer> findAll() {
        TypedQuery<Customer> query = entityManager.createQuery("select s from Customer s", Customer.class);
        return query.getResultList();
    }

    @Override
    public Customer findById(int id) {
        Customer customer = entityManager.find(Customer.class, id);
        return customer;
    }

    @Override
    public void save(Customer customer) {
        entityManager.persist(customer);
    }

    @Override
    public void update(Customer customer) {
        entityManager.merge(customer);
    }

    @Override
    public void removeById(int id) {
        entityManager.remove(id);
    }
}
