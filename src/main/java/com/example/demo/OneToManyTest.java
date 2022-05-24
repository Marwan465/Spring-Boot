package com.example.demo;

import com.example.demo.Entity.Courses;
import com.example.demo.Entity.Instructor;
import com.example.demo.Entity.instructorDetail;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToManyTest {
    
    public static void main(String[] args)  { 


        Instructor tempInstructor = new Instructor("Yasser", "Mourad");
        instructorDetail tempiInstructorDetail = new instructorDetail("http://www.Ph.com/youtube", "Cars");
       
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
           Courses tempcourse = new Courses("Arabic101");
            Courses tempcourse1 = new Courses("Arabic202");
            Courses tempcourse2 = new Courses("Arabic302");
            Instructor tempInstructor2 = session.get(Instructor.class, 20);
            tempInstructor2.BiDirectional(tempcourse);
            tempInstructor2.BiDirectional(tempcourse1);
            tempInstructor2.BiDirectional(tempcourse2);
            session.save(tempcourse);
            session.save(tempcourse1); 
            session.save(tempcourse2); 
            //Courses tempCourses = session.get(Courses.class, 14);
            //session.delete(tempCourses);
            
            
            
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