package com.springboot.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {

	@Autowired
	TopicRepository topicRepository;
	
	private List<Topic> topics = new ArrayList<>(Arrays.asList(
			new Topic("Spring","Spring Framework","Spring Description"),
			new Topic("Java","Core Java","Java Description"),
			new Topic("Python","Python Programming","Python Description")));
	
	public List<Topic> getTopics() {
		//return topics;
		List<Topic> topics = new ArrayList<>();
		
		topicRepository.findAll().forEach(topics::add);
		return topics;
	}
	
	public Topic getTopicById(String id) {
		//return topics.stream().filter(t->t.getId().equals(id)).findAny().get();
		return topicRepository.findById(id).get();
	}
	
	public List<Topic> createNewTopic(Topic topic) {
		//topics.add(topic);
		//return topics;
		topicRepository.save(topic);
		return this.getTopics();
		
	}

	public List<Topic> updateTopic(String id, Topic topic) {
		// TODO Auto-generated method stub
//		for(int i=0; i<topics.size();i++) {
//			Course t = topics.get(i);
//			if(t.getId().equals(id)) {
//				topics.set(i, topic);
//				break;
//			}
//		}
//		return topics;
		topicRepository.save(topic);
		return this.getTopics();
	}

	public List<Topic> deleteTopic(String id) {
		// TODO Auto-generated method stub
//		topics.removeIf(t->t.getId().equals(id));
//		return topics;
		topicRepository.deleteById(id);
		return this.getTopics();
	}
}
	

	