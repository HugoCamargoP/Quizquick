package com.quizquick.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "token")
public class Token {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idToken;
    private String token;
    private Date date;
    private String status;
    private String keyt;
    private String turn;
    @ManyToOne
    private User user;

    public Token () {}

    public Token(String token, Date date, String status, String keyt, String turn, User user) {
        this.setToken(token);
        this.setDate(date);
        this.setStatus(status);
        this.setKeyt(keyt);
        this.setTurn(turn);
        this.setUser(user);
    }

    public Token(String token, Date date, String status, String keyt, String turn) {
        this.setToken(token);
        this.setDate(date);
        this.setStatus(status);
        this.setKeyt(keyt);
        this.setTurn(turn);
    }


    public int getIdToken() {
        return idToken;
    }

    public void setIdToken(int idToken) {
        this.idToken = idToken;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getKeyt() {
        return keyt;
    }

    public void setKeyt(String keyt) {
        this.keyt = keyt;
    }

    public String getTurn() {
        return turn;
    }

    public void setTurn(String turn) {
        this.turn = turn;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Token{" +
                "idToken=" + idToken +
                ", token='" + token + '\'' +
                ", date=" + date +
                ", status='" + status + '\'' +
                ", keyt='" + keyt + '\'' +
                ", turn='" + turn + '\'' +
                ", user=" + user +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Token)) return false;
        Token token1 = (Token) o;
        return getIdToken() == token1.getIdToken() &&
                Objects.equals(getToken(), token1.getToken()) &&
                Objects.equals(getDate(), token1.getDate()) &&
                Objects.equals(getStatus(), token1.getStatus()) &&
                Objects.equals(getKeyt(), token1.getKeyt()) &&
                Objects.equals(getTurn(), token1.getTurn()) &&
                Objects.equals(getUser(), token1.getUser());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdToken(), getToken(), getDate(), getStatus(), getKeyt(), getTurn(), getUser());
    }
}
