package com.springboot.course;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.springboot.topic.Topic;

@Entity
public class Course {

	@Id
	private String id;
	private String name;
	private String Description;
	
	@ManyToOne
	private Topic topic;
	
	public Course() {}

	public Course(String id, String name, String description, String topicId) {
		super();
		this.id = id;
		this.name = name;
		Description = description;
		this.topic = new Topic(topicId,"","");
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", Description=" + Description + "]";
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	
	
}
