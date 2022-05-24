package customer.tracker.demo.DAO;

import java.util.List;

import customer.tracker.demo.Entities.Customer;

public interface CustomerDao {

    public List<Customer> getCustomers();
    public void addCustomer(Customer customer);
    public void updateCustomer(Customer customer);
    public void deleteCustomer(Customer customer);
    public Customer getCustomer(int customerId);
}
