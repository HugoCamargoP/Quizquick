package com.quizquick.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idQuestion;
    private String question;
    private int statusQuestion;
    @ManyToOne
    private SubTopic subTopic;
    @ManyToMany
    private User user;
    @ManyToMany
    private CorrectAnswer correctAnswer;
    @ManyToMany
    private WrongAnswer wrongAnswer;

    public Question () {}

    public Question(String question, int statusQuestion) {
        this.question = question;
        this.statusQuestion = statusQuestion;
    }

    public Question(String question, int statusQuestion, SubTopic subTopic) {
        this.question = question;
        this.statusQuestion = statusQuestion;
        this.subTopic = subTopic;
    }

    public int getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(int idQuestion) {
        this.idQuestion = idQuestion;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getStatusQuestion() {
        return statusQuestion;
    }

    public void setStatusQuestion(int statusQuestion) {
        this.statusQuestion = statusQuestion;
    }

    public SubTopic getSubTopic() {
        return subTopic;
    }

    public void setSubTopic(SubTopic subTopic) {
        this.subTopic = subTopic;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Question{" +
                "idQuestion=" + idQuestion +
                ", question='" + question + '\'' +
                ", statusQuestion=" + statusQuestion +
                ", subTopic=" + subTopic +
                ", user=" + user +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Question)) return false;
        Question question1 = (Question) o;
        return getIdQuestion() == question1.getIdQuestion() &&
                getStatusQuestion() == question1.getStatusQuestion() &&
                Objects.equals(getQuestion(), question1.getQuestion()) &&
                Objects.equals(getSubTopic(), question1.getSubTopic()) &&
                Objects.equals(getUser(), question1.getUser());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdQuestion(), getQuestion(), getStatusQuestion(), getSubTopic(), getUser());
    }
}
