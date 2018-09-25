package com.generation.beans;
// Generated 24/09/2018 11:42:11 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Topic generated by hbm2java
 */
public class Topic  implements java.io.Serializable {


     private Integer idTopic;
     private Module module;
     private String nombreTopic;
     private Integer topicStatus;
     private Set subtopics = new HashSet(0);

    public Topic() {
    }

	
    public Topic(Module module) {
        this.module = module;
    }
    public Topic(Module module, String nombreTopic, Integer topicStatus, Set subtopics) {
       this.module = module;
       this.nombreTopic = nombreTopic;
       this.topicStatus = topicStatus;
       this.subtopics = subtopics;
    }
   
    public Integer getIdTopic() {
        return this.idTopic;
    }
    
    public void setIdTopic(Integer idTopic) {
        this.idTopic = idTopic;
    }
    public Module getModule() {
        return this.module;
    }
    
    public void setModule(Module module) {
        this.module = module;
    }
    public String getNombreTopic() {
        return this.nombreTopic;
    }
    
    public void setNombreTopic(String nombreTopic) {
        this.nombreTopic = nombreTopic;
    }
    public Integer getTopicStatus() {
        return this.topicStatus;
    }
    
    public void setTopicStatus(Integer topicStatus) {
        this.topicStatus = topicStatus;
    }
    public Set getSubtopics() {
        return this.subtopics;
    }
    
    public void setSubtopics(Set subtopics) {
        this.subtopics = subtopics;
    }




}


