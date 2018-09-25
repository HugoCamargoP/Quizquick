package com.generation.beans;
// Generated 24/09/2018 11:42:11 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Subtopic generated by hbm2java
 */
public class Subtopic  implements java.io.Serializable {


     private Integer idsubtopics;
     private Topic topic;
     private String nombreSubtopic;
     private Integer subtopicStatus;
     private Set questions = new HashSet(0);

    public Subtopic() {
    }

	
    public Subtopic(Topic topic) {
        this.topic = topic;
    }
    public Subtopic(Topic topic, String nombreSubtopic, Integer subtopicStatus, Set questions) {
       this.topic = topic;
       this.nombreSubtopic = nombreSubtopic;
       this.subtopicStatus = subtopicStatus;
       this.questions = questions;
    }
   
    public Integer getIdsubtopics() {
        return this.idsubtopics;
    }
    
    public void setIdsubtopics(Integer idsubtopics) {
        this.idsubtopics = idsubtopics;
    }
    public Topic getTopic() {
        return this.topic;
    }
    
    public void setTopic(Topic topic) {
        this.topic = topic;
    }
    public String getNombreSubtopic() {
        return this.nombreSubtopic;
    }
    
    public void setNombreSubtopic(String nombreSubtopic) {
        this.nombreSubtopic = nombreSubtopic;
    }
    public Integer getSubtopicStatus() {
        return this.subtopicStatus;
    }
    
    public void setSubtopicStatus(Integer subtopicStatus) {
        this.subtopicStatus = subtopicStatus;
    }
    public Set getQuestions() {
        return this.questions;
    }
    
    public void setQuestions(Set questions) {
        this.questions = questions;
    }




}

