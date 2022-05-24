package com.example.demo.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "course_student")
public class Course_Student {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private int course_id;
    
    private int student_id;


    public Course_Student() {
    }

    public int getCourse_id() {
        return this.course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public int getStudent_id() {
        return this.student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    
}
