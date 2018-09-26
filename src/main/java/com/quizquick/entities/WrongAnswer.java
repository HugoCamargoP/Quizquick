package com.quizquick.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "wronganswer")
public class WrongAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idWrongAnswer;
    private String wrongAnswer;
    private int statusWrongAnswer;
    @ManyToMany
    private Question question;

    public WrongAnswer () {}

    public WrongAnswer(String wrongAnswer, int statusWrongAnswer) {
        this.wrongAnswer = wrongAnswer;
        this.statusWrongAnswer = statusWrongAnswer;
    }

    public int getIdWrongAnswer() {
        return idWrongAnswer;
    }

    public void setIdWrongAnswer(int idWrongAnswer) {
        this.idWrongAnswer = idWrongAnswer;
    }

    public String getWrongAnswer() {
        return wrongAnswer;
    }

    public void setWrongAnswer(String wrongAnswer) {
        this.wrongAnswer = wrongAnswer;
    }

    public int getStatusWrongAnswer() {
        return statusWrongAnswer;
    }

    public void setStatusWrongAnswer(int statusWrongAnswer) {
        this.statusWrongAnswer = statusWrongAnswer;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return "WrongAnswer{" +
                "idWrongAnswer=" + idWrongAnswer +
                ", wrongAnswer='" + wrongAnswer + '\'' +
                ", statusWrongAnswer=" + statusWrongAnswer +
                ", question=" + question +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WrongAnswer)) return false;
        WrongAnswer that = (WrongAnswer) o;
        return getIdWrongAnswer() == that.getIdWrongAnswer() &&
                getStatusWrongAnswer() == that.getStatusWrongAnswer() &&
                Objects.equals(getWrongAnswer(), that.getWrongAnswer()) &&
                Objects.equals(getQuestion(), that.getQuestion());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdWrongAnswer(), getWrongAnswer(), getStatusWrongAnswer(), getQuestion());
    }


}

