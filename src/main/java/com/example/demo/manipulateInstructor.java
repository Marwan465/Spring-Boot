package com.example.demo;

import com.example.demo.Entity.Courses;
import com.example.demo.Entity.Instructor;
import com.example.demo.Entity.instructorDetail;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class manipulateInstructor {
    public static void main(String[] args)  { 


        Instructor tempInstructor = new Instructor("ali", "mourad");
        instructorDetail tempiInstructorDetail = new instructorDetail("http://www.Arabic.com/youtube", "cars");
       tempInstructor.setInstrDetail(tempiInstructorDetail);

        SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
                                .addAnnotatedClass(instructorDetail.class)
                                .addAnnotatedClass(Courses.class)
								.buildSessionFactory();
		Session session = factory.getCurrentSession();

        try {
            //ADD NEW INSTRUCTOR
            session.beginTransaction();

            //session.save(tempInstructor);
           Instructor tempInstructor2 = session.get(Instructor.class, 20);
            for(Courses c : tempInstructor2.getCourses()) {
                c.setInstructor(null);
            }
            
            session.delete(tempInstructor2);
         
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
