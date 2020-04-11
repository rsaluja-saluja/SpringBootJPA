package com.springboot.topic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {

	@Autowired
	private TopicService topicService;
	
	@RequestMapping("/topics")
	public List<Topic> getTopics() {
		System.out.println("getTopics");
		return topicService.getTopics();
	}
	
	@RequestMapping("/topics/{id}")
	public Topic getTopic(@PathVariable("id") String id) {
		return topicService.getTopicById(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/topics")
	public List<Topic> createTopic(@RequestBody Topic topic) {
		return topicService.createNewTopic(topic);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/topics/{id}")
	public List<Topic> updateTopic(@RequestBody Topic topic, @PathVariable("id") String id) {
		return topicService.updateTopic(id, topic);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/topics/{id}")
	public List<Topic> deleteTopic(@PathVariable("id") String id) {
		return topicService.deleteTopic(id);
	}
}
