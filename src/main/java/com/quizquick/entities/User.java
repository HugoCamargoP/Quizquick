package com.quizquick.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUser;
    private String mail;
    private String pass;
    private String nick;
    private int userStatus;
    @ManyToMany
    private Question question;

    public User () {}

    public User(String mail, String pass, String nick, int userStatus) {
        this.setMail(mail);
        this.setPass(pass);
        this.setNick(nick);
        this.setUserStatus(userStatus);
    }


    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public int getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(int userStatus) {
        this.userStatus = userStatus;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return "User{" +
                "idUser=" + idUser +
                ", mail='" + mail + '\'' +
                ", pass='" + pass + '\'' +
                ", nick='" + nick + '\'' +
                ", userStatus=" + userStatus +
                ", question=" + question +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getIdUser() == user.getIdUser() &&
                getUserStatus() == user.getUserStatus() &&
                Objects.equals(getMail(), user.getMail()) &&
                Objects.equals(getPass(), user.getPass()) &&
                Objects.equals(getNick(), user.getNick()) &&
                Objects.equals(getQuestion(), user.getQuestion());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdUser(), getMail(), getPass(), getNick(), getUserStatus(), getQuestion());
    }
}
