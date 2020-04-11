package com.springboot.course;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

	@Autowired
	CourseRepository courseRepository;
	
//	private List<Course> courses = new ArrayList<>(Arrays.asList(
//			new Course("Spring","Spring Framework","Spring Description"),
//			new Course("Java","Core Java","Java Description"),
//			new Course("Python","Python Programming","Python Description")));
//	
	public List<Course> getCourses(String topicId) {
		//return courses;
		List<Course> courses = new ArrayList<>();
		
		courseRepository.findByTopicId(topicId).forEach(courses::add);
		return courses;
	}
	
	public Course getCourseById(String courseId) {
		//return courses.stream().filter(t->t.getId().equals(id)).findAny().get();
		return courseRepository.findById(courseId).get();
	}
	
	public List<Course> createNewCourse(Course course) {
		//courses.add(topic);
		//return courses;
		courseRepository.save(course);
		return this.getCourses(course.getTopic().getId());
		
	}

	public List<Course> updateCourse(Course course) {
		// TODO Auto-generated method stub
//		for(int i=0; i<courses.size();i++) {
//			Course t = courses.get(i);
//			if(t.getId().equals(id)) {
//				courses.set(i, topic);
//				break;
//			}
//		}
//		return courses;
		courseRepository.save(course);
		return this.getCourses(course.getTopic().getId());
	}

	public List<Course> deleteCourse(String topicId, String courseId) {
		// TODO Auto-generated method stub
//		courses.removeIf(t->t.getId().equals(id));
//		return courses;
		courseRepository.deleteById(courseId);
		return this.getCourses(topicId);
	}
}
	

	