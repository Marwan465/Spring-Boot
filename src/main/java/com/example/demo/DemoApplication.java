package com.example.demo;

import com.example.demo.Entity.Cars;
import com.example.demo.Entity.Student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.addAnnotatedClass(Cars.class)
								.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			//todo
			Student std1 = new Student("Marwan","elsharqawy","miro@gmail.com");
			Cars car = new Cars("BMW", "X6");
			session.beginTransaction();
			session.save(std1);
			
			
			session.getTransaction().commit();
			session.beginTransaction();
			
			session.save(car);
			
			session.getTransaction().commit();
		} catch(Exception e){
			e.printStackTrace();

		}finally {
			factory.close();
		}
	}

}
