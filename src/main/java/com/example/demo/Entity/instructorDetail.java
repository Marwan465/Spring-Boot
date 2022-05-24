package com.example.demo.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="instructor_details")
public class instructorDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="youtube_channel")
    private String youtubeChannel;
    @Column
    private String hobby;

    @OneToOne(mappedBy = "instrDetail", 
    cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,
    CascadeType.REFRESH}) //making it BI-Directional Relation NOTE REMOVED the remove cascade tonot delete the instructor with the instructor detail
    private Instructor instructor;

    public instructorDetail() {
    }

    public instructorDetail(String youtubeChannel, String hobby) {
        this.youtubeChannel = youtubeChannel;
        this.hobby = hobby;
    }
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getYoutubeChannel() {
        return this.youtubeChannel;
    }

    public void setYoutubeChannel(String youtubeChannel) {
        this.youtubeChannel = youtubeChannel;
    }

    public String getHobby() {
        return this.hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public Instructor getInstructor() {
        return this.instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }
        
        
    @Override
	public String toString() {
		return "Instructor_Details [id=" + id + ", YouTube Channel=" + youtubeChannel + ", hobby=" + hobby  + "]";
	}
    
}
