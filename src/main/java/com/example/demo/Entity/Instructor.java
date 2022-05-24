package com.example.demo.Entity;





import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PreRemove;

@Entity
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="First_Name")
    private String firstName;
    @Column(name="Last_Name")
    private String lastName;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="instructor_detail_id")
    private instructorDetail instrDetail;

    @OneToMany(mappedBy = "instructor", 
        cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    private List<Courses> courses;

    public Instructor() {
    }

    public Instructor(String firstName, String lastName) {
        
        this.firstName = firstName;
        this.lastName = lastName;
        
    }
    //add convenience methods for bi-directional relationship
    public void BiDirectional(Courses tempCourse) {
        if(courses == null) {
            courses = new ArrayList<Courses>();
        }
        tempCourse.setInstructor(this);
        courses.add(tempCourse);
        
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
 

    public instructorDetail getInstrDetail() {
        return this.instrDetail;
    }

    public void setInstrDetail(instructorDetail instrDetail) {
        this.instrDetail = instrDetail;
    }


    public List<Courses> getCourses() {
        return this.courses;
    }

    public void setCourses(List<Courses> courses) {
        this.courses = courses;
    }

    @PreRemove
    public void checkReviewAssociationBeforeRemoval() {
        if (!this.courses.isEmpty()) {
            for(Courses c : this.courses) {
                if(c.getInstructor() != null) {
                    System.out.println("CANNOT remove an instructor with course/s' until course/s' instructor id are set to null");
                    throw new RuntimeException("Can't remove an instructor with course until courses instructor id are set to null");
                    
                }
            }
           
        }
    }


    @Override
	public String toString() {
		return "Instructor [id=" + id + ", First Name = " + firstName + ", Last Name = " + lastName  + "]";
	}
    
}
