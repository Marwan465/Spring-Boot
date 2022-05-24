package customer.tracker.demo.implementations;

import java.util.List;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import customer.tracker.demo.DAO.CustomerDao;
import customer.tracker.demo.Entities.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDao {

    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public List<Customer> getCustomers() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Customer> theQuery = currentSession.createQuery("from Customer order by id", Customer.class);
        List<Customer> customers = theQuery.getResultList();
        return customers;
    }
    @Override
    public void addCustomer(Customer customer) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save(customer);
        
        
    }
    @Override
    public void updateCustomer(Customer customer) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(customer);
        
    }
    @Override
    public void deleteCustomer(Customer customer) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.remove(customer);
        
    }
    @Override
    public Customer getCustomer(int customerId) {
        Session currentSession = sessionFactory.getCurrentSession();
        
        return currentSession.get(Customer.class, customerId);
    }
    
}
