package com.springtutorial.springtutorial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Controller class
@RestController
public class TopicController {


    @Autowired
    private TopicService topicservice;

    // method to access or list all the TOPICS
    @RequestMapping("/topics")
    public List<Topics> topics(){
        return topicservice.getAllTopics();
    }

    // method to access the one topic form the TOPICS.
    @RequestMapping("/topics/{id}")
    public Topics oneTopic(@PathVariable String id){
        return topicservice.getTopic(id);
    }

    // post method for adding topics in the list.
    @RequestMapping(method = RequestMethod.POST, value="/topics")
    public void addTopic(@RequestBody Topics topics){
        topicservice.addTopic(topics);
    }

    // delete method for removie topic form the list.
    @RequestMapping(method = RequestMethod.DELETE,value = "/topics/{id}")
    public void delete(@PathVariable String id){
        topicservice.delete(id);
    }
    // This method get the name through the POST request and display the name in json format.
    @RequestMapping(method = RequestMethod.POST,value="/hello")
    public Greeting hello(@RequestBody Greeting gre){
        return new Greeting("Hello "+gre.getName());
    }

}
