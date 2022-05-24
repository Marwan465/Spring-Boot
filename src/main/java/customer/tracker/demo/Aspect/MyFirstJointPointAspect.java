package customer.tracker.demo.Aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import customer.tracker.demo.Entities.Customer;

@Aspect
@Component
@Order(0)
public class MyFirstJointPointAspect {
    @Pointcut("execution(* getCustomers())")
    public void gettingCustomer(){}
    @Pointcut("execution(* addCustomer(..))")
    public void addingCustomer(){}
    @Before("execution(* customer.tracker.demo.implementations.CustomerDAOImpl.getCustomers())")
    public void beforeGetCustomerAdvic(JoinPoint theJoinPoint) {
        MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
        System.out.println("Method: " + methodSignature);
    }
    @Before("execution(* addCustomer(..))")
    public void beforeAddAnyCustomersAdvice(JoinPoint theJoinPoint) {
        Object[] arguments = theJoinPoint.getArgs();
        for(Object args : arguments) {
            System.out.println("Arguments : " + args);
        }

    }
    @AfterReturning(pointcut = "gettingCustomer()", returning = "result")
    public void afterAddAnyCustomersAdvice(JoinPoint theJoinPoint, List<Customer> result) {
        Object[] arguments = theJoinPoint.getArgs();
        for(Object args : arguments) {
            System.out.println("Arguments : " + args);
        }
       
        System.out.println("Customers : " + result);
        for(Customer customer : result) {
            System.out.println("Customer Name : " + customer.getFirstName());  
            if(customer.getFirstName()== null) {
                customer.setFirstName("John");
                customer.setLastName("Doe");
                customer.setEmail("JohnDoe@gmail.com");
            } 
        }
       
    }
    
    @AfterThrowing(pointcut = "addingCustomer()", throwing= "e")
    public void addingCustomerException(JoinPoint theJoinPoint, Throwable e) {
        System.out.println("Exception : " + e);
        
    }
    @After("gettingCustomer()")
    public void afterAddAnyCustomersFinallyAdvice(JoinPoint theJoinPoint) {
        MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
        
        System.out.println("Method Finally : " + methodSignature);
  
   
}
    
    @Around("gettingCustomer()")
    public Object aroundGetCustomersAdvice(ProceedingJoinPoint thepProceedingJoinPoint) throws Throwable {
       String method = thepProceedingJoinPoint.getSignature().toShortString();
       System.out.println("@around Method : " + method);
        Long begin= System.currentTimeMillis();
        Object result = null;
        try {
         result = thepProceedingJoinPoint.proceed();
        } catch(Exception e) {
            System.out.println("@Around Advice  WE GOT A PROBLEM! " + e);
            //throw e; rethrow the exception
        }

        long end = System.currentTimeMillis();
        long duration = end - begin;
        System.out.println("Duration : " + duration + "milliseconds");
        return result;
}

}

