package com.quizquick.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "subtopic")
public class SubTopic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSubTopic;
    private String nameSubTopic;
    private int statusSubTopic;
    @ManyToOne
    private Topic topic;

    public  SubTopic () {}

    public SubTopic(String nameSubTopic, int statusSubTopic) {
        this.nameSubTopic = nameSubTopic;
        this.statusSubTopic = statusSubTopic;
    }

    public SubTopic(String nameSubTopic, int statusSubTopic, Topic topic) {
        this.nameSubTopic = nameSubTopic;
        this.statusSubTopic = statusSubTopic;
        this.topic = topic;
    }

    public int getIdSubTopic() {
        return idSubTopic;
    }

    public void setIdSubTopic(int idSubTopic) {
        this.idSubTopic = idSubTopic;
    }

    public String getNameSubTopic() {
        return nameSubTopic;
    }

    public void setNameSubTopic(String nameSubTopic) {
        this.nameSubTopic = nameSubTopic;
    }

    public int getStatusSubTopic() {
        return statusSubTopic;
    }

    public void setStatusSubTopic(int statusSubTopic) {
        this.statusSubTopic = statusSubTopic;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    @Override
    public String toString() {
        return "SubTopic{" +
                "idSubTopic=" + idSubTopic +
                ", nameSubTopic='" + nameSubTopic + '\'' +
                ", statusSubTopic=" + statusSubTopic +
                ", topic=" + topic +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SubTopic)) return false;
        SubTopic subTopic = (SubTopic) o;
        return getIdSubTopic() == subTopic.getIdSubTopic() &&
                getStatusSubTopic() == subTopic.getStatusSubTopic() &&
                Objects.equals(getNameSubTopic(), subTopic.getNameSubTopic()) &&
                Objects.equals(getTopic(), subTopic.getTopic());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdSubTopic(), getNameSubTopic(), getStatusSubTopic(), getTopic());
    }
}
