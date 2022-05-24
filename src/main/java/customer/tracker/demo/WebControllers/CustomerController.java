package customer.tracker.demo.WebControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import customer.tracker.demo.DAO.CustomerDao;
import customer.tracker.demo.Entities.Customer;
import customer.tracker.demo.Services.CustomerService;




@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService ;
    @GetMapping("/list")
    public String listCustomers(Model themodel) {

        List<Customer> theCustomers = customerService.getCustomers();
        System.out.println(theCustomers);
        themodel.addAttribute("customers", theCustomers);
        return "list-customers";
    }
    @GetMapping("/CustomerForm") 
    public String CustomerForm(Model theModel) {
        Customer theCustomer = new Customer();
        theModel.addAttribute("customer", theCustomer);
        return "customer-form";
    }
    @GetMapping("/CustomerUpdateForm/{customerId}") 
    public String CustomerUpdateForm(@PathVariable("customerId") int id, Model theModel) {
        Customer theCustomer = customerService.getCustomer(id);
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!222222! "+theCustomer);
        theModel.addAttribute("customer", theCustomer);
        return "customer-update-form";
    }
    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer thecustomer) {
        //System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! "+thecustomer);
        customerService.addCustomer(thecustomer);
        return "redirect:/customer/list";
    }
    @PostMapping("/updateCustomer")
    public String updateCustomer(@ModelAttribute("id") int customerId) {
        
        customerService.updateCustomer(customerService.getCustomer(customerId));
        return "redirect:/customer/list";
    }
    
    
}
