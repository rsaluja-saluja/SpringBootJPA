package com.springboot.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.topic.Topic;

@RestController
public class CourseController {

	@Autowired
	private CourseService courseService;
	
	@RequestMapping("/topics/{topicId}/courses")
	public List<Course> getCourses(@PathVariable("topicId") String topicId) {
		System.out.println("getCourses");
		return courseService.getCourses(topicId);
	}
	
	@RequestMapping("/topics/{topicId}/courses/{courseId}")
	public Course getCourse(@PathVariable("courseId") String courseId) {
		return courseService.getCourseById(courseId);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/topics/{topicId}/courses")
	public List<Course> createCourse(@RequestBody Course course, @PathVariable("topicId") String topicId) {
		course.setTopic(new Topic(topicId,"",""));
		return courseService.createNewCourse(course);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/topics/{topicId}/courses/{courseId}")
	public List<Course> updateCourse(@RequestBody Course course,@PathVariable("topicId") String topicId, @PathVariable("courseId") String id) {
		course.setTopic(new Topic(topicId,"",""));
		return courseService.updateCourse(course);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/topics/{topicId}/courses/{courseId}")
	public List<Course> deleteTopic(@PathVariable("topicId") String topicId,@PathVariable("courseId") String courseId) {
		return courseService.deleteCourse(topicId, courseId);
	}
}
