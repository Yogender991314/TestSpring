package com.springtutorial.springtutorial;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {

    //List of Topics hardcoded.
    private List<Topics> topics = new ArrayList<>( Arrays.asList(
        new Topics("Spring1","Spring Tutorials1","Im Studying :)"),
                new Topics("Spring2","Spring Tutorials2","Im Studying :("),
                new Topics("Spring3","Spring Tutorials3","Im Studying :)"),
                new Topics("Spring4","Spring Tutorials4","Im Studying :(")
        ));

    //method to access list
    public List<Topics> getAllTopics() {
        return topics;
    }

    //method to get topics by id
    public Topics getTopic(String id ){
        return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
    }

    // method to add topic in the list
    public void addTopic(Topics t){
        topics.add(t);
    }

    //method to delete topic from the list
    public void delete(String id){
        topics.remove(topics.stream().filter(t -> t.getId().equals(id)).findFirst().get());
    }
}
