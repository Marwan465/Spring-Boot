package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

import com.example.demo.Entity.Student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class JHibernateTest {
    public static void main(String[] args)  {
    String jdbcUrl="jdbc:mysql://localhost:3306/hiber_try";
    try {
        System.out.println("Connecting to database: " + jdbcUrl);
        Connection myConn =DriverManager.getConnection(jdbcUrl, "root", "303030Miro");
        System.out.println("Connection Successful!" + myConn );
		myConn.close();
    }
    catch(Exception e) {
        e.printStackTrace();
    } 
    SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			//todo
			Student std1 = new Student("Marwan","elsharqawy","miro@gmail.com");
			session.beginTransaction();
			session.save(std1);
			session.getTransaction().commit();

			System.out.println("Saved Student : " + std1.getId());

			session = factory.getCurrentSession();
			session.beginTransaction();
			Student mystd=session.get(Student.class, std1.getId());
			mystd.setFirstName("Scooby");
			System.out.println("Done : " + mystd.getFirstName() + " "+ mystd.getLastName());
			session.getTransaction().commit();
			session = factory.getCurrentSession();
			session.beginTransaction();
			List<Student> theStudents = session.createQuery("from Student").list();
			printStudents(theStudents, "ALL");
			theStudents =session.createQuery("from Student s where s.email='miro.gmail.com'").list();
			printStudents(theStudents, "EMAIL");
			session.createQuery("update Student s set email='foo@gmail.com' where s.email='miro.gmail.com'")
					.executeUpdate();
			session.createQuery("delete from Student where id=30")
					.executeUpdate();
			session.getTransaction().commit();
			

		} catch(Exception e){
			e.printStackTrace();

		}finally {
			factory.close();
		}

}


public static void printStudents(List<Student> theStudents, String w) {
	for (Student s : theStudents) {
		System.out.println("Done " + w + ": " + s);
	}
}
}
