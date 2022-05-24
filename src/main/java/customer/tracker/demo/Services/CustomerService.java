package customer.tracker.demo.Services;

import java.util.List;

import customer.tracker.demo.Entities.Customer;

public interface CustomerService {

    public List<Customer> getCustomers();
    public void addCustomer(Customer customer);
    public void updateCustomer(Customer customer);
    public void deleteCustomer(Customer customer);
    public Customer getCustomer(int coustmerId);
    
}
