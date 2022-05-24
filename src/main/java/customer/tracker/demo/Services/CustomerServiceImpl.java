package customer.tracker.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import customer.tracker.demo.DAO.CustomerDao;
import customer.tracker.demo.Entities.Customer;

@Service
public class CustomerServiceImpl  implements CustomerService {
    @Autowired
    CustomerDao customerDao;
    @Override
    @Transactional
    public List<Customer> getCustomers() {
        
        return customerDao.getCustomers();
    }
    @Override
    @Transactional
    public void addCustomer(Customer customer) {
        customerDao.addCustomer(customer);
        
    }
    @Override
    @Transactional
    public void updateCustomer(Customer customer) {
        customerDao.updateCustomer(customer);
        
    }
    @Override
    @Transactional
    public void deleteCustomer(Customer customer) {
        customerDao.deleteCustomer(customer);
        
    }
    @Override
    @Transactional
    public Customer getCustomer(int coustmerId) {
        
        return customerDao.getCustomer(coustmerId);
    }
    
}
