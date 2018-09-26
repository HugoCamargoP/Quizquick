package com.quizquick.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "topic")
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTopic;
    private String nameTopic;
    private int statusTopic;
    @ManyToOne
    private Module module;

    public Topic () {}

    public Topic(String nameTopic, int statusTopic) {
        this.nameTopic = nameTopic;
        this.statusTopic = statusTopic;
    }

    public Topic(String nameTopic, int statusTopic, Module module) {
        this.nameTopic = nameTopic;
        this.statusTopic = statusTopic;
        this.module = module;
    }

    public int getIdTopic() {
        return idTopic;
    }

    public void setIdTopic(int idTopic) {
        this.idTopic = idTopic;
    }

    public String getNameTopic() {
        return nameTopic;
    }

    public void setNameTopic(String nameTopic) {
        this.nameTopic = nameTopic;
    }

    public int getStatusTopic() {
        return statusTopic;
    }

    public void setStatusTopic(int statusTopic) {
        this.statusTopic = statusTopic;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    @Override
    public String toString() {
        return "Topic{" +
                "idTopic=" + idTopic +
                ", nameTopic='" + nameTopic + '\'' +
                ", statusTopic=" + statusTopic +
                ", module=" + module +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Topic)) return false;
        Topic topic = (Topic) o;
        return getIdTopic() == topic.getIdTopic() &&
                getStatusTopic() == topic.getStatusTopic() &&
                Objects.equals(getNameTopic(), topic.getNameTopic()) &&
                Objects.equals(getModule(), topic.getModule());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdTopic(), getNameTopic(), getStatusTopic(), getModule());
    }
}
