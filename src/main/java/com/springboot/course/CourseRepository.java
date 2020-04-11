package com.springboot.course;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, String>{

	//No need to define these method Just declare by following the nameing convention and 
	// Spring JPA would define these.
//	public List<Course> findByName(String name);
//	public List<Course> findByDescription(String description);
//	
	public List<Course> findByTopicId(String TopicId);
}
