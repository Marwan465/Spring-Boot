package customer.tracker.demo;

import org.hibernate.SessionFactory;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;

import org.springframework.web.client.RestTemplate;

@Configuration
@ComponentScan
@EntityScan
@ServletComponentScan
@EnableAspectJAutoProxy
@ImportResource("spring-mvc-crud-demo-servlet.xml")
public class Config {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
    
    
}
