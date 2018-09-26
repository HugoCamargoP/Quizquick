package com.quizquick.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "correctanswer")
public class CorrectAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCorrectAnswer;
    private String answerCorrect;
    private int correctAnswerStatus;
    @ManyToMany
    private Question question;

    public CorrectAnswer(String answerCorrect, int correctAnswerStatus) {
        this.setAnswerCorrect(answerCorrect);
        this.setCorrectAnswerStatus(correctAnswerStatus);
    }


    public int getIdCorrectAnswer() {
        return idCorrectAnswer;
    }

    public void setIdCorrectAnswer(int idCorrectAnswer) {
        this.idCorrectAnswer = idCorrectAnswer;
    }

    public String getAnswerCorrect() {
        return answerCorrect;
    }

    public void setAnswerCorrect(String answerCorrect) {
        this.answerCorrect = answerCorrect;
    }

    public int getCorrectAnswerStatus() {
        return correctAnswerStatus;
    }

    public void setCorrectAnswerStatus(int correctAnswerStatus) {
        this.correctAnswerStatus = correctAnswerStatus;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CorrectAnswer)) return false;
        CorrectAnswer that = (CorrectAnswer) o;
        return getIdCorrectAnswer() == that.getIdCorrectAnswer() &&
                getCorrectAnswerStatus() == that.getCorrectAnswerStatus() &&
                Objects.equals(getAnswerCorrect(), that.getAnswerCorrect()) &&
                Objects.equals(getQuestion(), that.getQuestion());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdCorrectAnswer(), getAnswerCorrect(), getCorrectAnswerStatus(), getQuestion());
    }

    @Override
    public String toString() {
        return "CorrectAnswer{" +
                "idCorrectAnswer=" + idCorrectAnswer +
                ", answerCorrect='" + answerCorrect + '\'' +
                ", correctAnswerStatus=" + correctAnswerStatus +
                ", question=" + question +
                '}';
    }
}
