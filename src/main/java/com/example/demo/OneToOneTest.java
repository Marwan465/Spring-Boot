package com.example.demo;

import com.example.demo.Entity.Instructor;
import com.example.demo.Entity.instructorDetail;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToOneTest {
    public static void main(String[] args)  { 


        Instructor tempInstructor = new Instructor("Yasser", "Mourad");
        instructorDetail tempiInstructorDetail = new instructorDetail("http://www.Ph.com/youtube", "Cars");
       tempInstructor.setInstrDetail(tempiInstructorDetail);

        SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
                                .addAnnotatedClass(instructorDetail.class)
								.buildSessionFactory();
		Session session = factory.getCurrentSession();

        try {
            //ADD NEW INSTRUCTOR
            session.beginTransaction();

            session.save(tempInstructor);
            session.getTransaction().commit();
           
            //GET INSTRUCTOR DETAIL OBJECT
            int theId=12;
            session = factory.getCurrentSession();
			session.beginTransaction();
            instructorDetail tempInstructorDetail = session.get(instructorDetail.class, theId);
           
            System.out.println("Instructor Details : " + tempInstructorDetail);
            System.out.println("Instructor : " + tempInstructorDetail.getInstructor());
            //break bi-dircetional link so we can delete instructor detail
            /*tempInstructorDetail.getInstructor().setInstrDetail(null);
            session.delete(tempInstructorDetail);*/
            session.getTransaction().commit();
           
            



        }
        catch(Exception e) {
            e.printStackTrace();

        } finally {
            session.close();
            factory.close();
        }





    }
    
}
