package com.example.demo;

import com.example.demo.Entity.Course_Student;
import com.example.demo.Entity.Courses;
import com.example.demo.Entity.Instructor;
import com.example.demo.Entity.Student;
import com.example.demo.Entity.instructorDetail;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ManyToManyTest {
    public static void main(String[] args)  { 
        Courses tempCourse = new Courses("MATH401");
        Courses tempCourse1 = new Courses("CS402");
        Courses tempCourse3 = new Courses("CS403");
        SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Course_Student.class)
                                .addAnnotatedClass(Student.class)
                                .addAnnotatedClass(Courses.class)
                                .addAnnotatedClass(Instructor.class)
                                .addAnnotatedClass(instructorDetail.class)
								.buildSessionFactory();
		Session session = factory.getCurrentSession();


        try {
            session.beginTransaction();
            /*Student tempStudent = session.get(Student.class, 2);
            tempStudent.addCourse(tempCourse);
            tempStudent.addCourse(tempCourse1);
            tempStudent.addCourse(tempCourse3);
            session.save(tempCourse);
            session.save(tempCourse1);
            session.save(tempCourse3);*/
            Student tempStudent = session.get(Student.class, 2);
            System.out.println(" Student's : " + tempStudent +
             " Courses : " + tempStudent.getCourses());

            session.getTransaction().commit();

        }
        catch(Exception e) {
            e.printStackTrace();
        }finally {
            session.close();
            factory.close();
        }


    }
    
}
