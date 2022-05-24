package customer.tracker.demo.Aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyFirstLoggingAspect {
    @Pointcut("execution(* addCustomer(..))") //pointcut declarations to prevent copy and past
    private void forDaoPackage(){}
    @Pointcut("execution(* customer.tracker.demo.*.set*(..))") //pointcut declarations to prevent copy and past
    private void forSetters(){}
    @Before("forDaoPackage() && !forSetters()") //execlude the setter pointcut
    public void GetCustomersAdvice() {
        System.out.println("Executing @Before advice on getCustomers() from pointcut");
    }
    @Before("forSetters()")
    public void SetterAdvice() {
        System.out.println("Executing @Before advice on setter methods");
    }

    @Before("execution(* customer.tracker.demo.implementations.CustomerDAOImpl.getCustomers())")
    public void beforeGetCustomersAdvice() {
        System.out.println("Executing @Before advice on getCustomers()");
    }
    @Before("execution(* getCustomers())")
    public void beforeAnyAdvice() {
        System.out.println("Executing @Before advice on Any()");
    }
    @Before("execution(* addCustomer(customer.tracker.demo.Entities.Customer))")
    public void beforeAddCustomersAdvice() {
        System.out.println("Executing @Before advice on ADDCustomers()");
    }
    @Before("execution(* addCustomer(..))")
    public void beforeAddAnyCustomersAdvice() {
        System.out.println("Executing @Before advice on ADDCustomers() of Any number of Argument of any type");
    }
    
}
