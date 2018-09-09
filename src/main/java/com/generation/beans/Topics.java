package com.generation.beans;
// Generated 9/09/2018 04:34:06 AM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Topics generated by hbm2java
 */
public class Topics  implements java.io.Serializable {


     private Integer idTopic;
     private Modules modules;
     private String nombreTopic;
     private Set subtopicses = new HashSet(0);

    public Topics() {
    }

	
    public Topics(Modules modules) {
        this.modules = modules;
    }
    public Topics(Modules modules, String nombreTopic, Set subtopicses) {
       this.modules = modules;
       this.nombreTopic = nombreTopic;
       this.subtopicses = subtopicses;
    }
   
    public Integer getIdTopic() {
        return this.idTopic;
    }
    
    public void setIdTopic(Integer idTopic) {
        this.idTopic = idTopic;
    }
    public Modules getModules() {
        return this.modules;
    }
    
    public void setModules(Modules modules) {
        this.modules = modules;
    }
    public String getNombreTopic() {
        return this.nombreTopic;
    }
    
    public void setNombreTopic(String nombreTopic) {
        this.nombreTopic = nombreTopic;
    }
    public Set getSubtopicses() {
        return this.subtopicses;
    }
    
    public void setSubtopicses(Set subtopicses) {
        this.subtopicses = subtopicses;
    }




}


