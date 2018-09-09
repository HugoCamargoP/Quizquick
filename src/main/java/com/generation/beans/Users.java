package com.generation.beans;
// Generated 9/09/2018 04:34:06 AM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Users generated by hbm2java
 */
public class Users  implements java.io.Serializable {


     private Integer idUser;
     private String mail;
     private String pass;
     private String nick;
     private Set tokenses = new HashSet(0);
     private Set questionses = new HashSet(0);

    public Users() {
    }

    public Users(String mail, String pass, String nick, Set tokenses, Set questionses) {
       this.mail = mail;
       this.pass = pass;
       this.nick = nick;
       this.tokenses = tokenses;
       this.questionses = questionses;
    }
   
    public Integer getIdUser() {
        return this.idUser;
    }
    
    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }
    public String getMail() {
        return this.mail;
    }
    
    public void setMail(String mail) {
        this.mail = mail;
    }
    public String getPass() {
        return this.pass;
    }
    
    public void setPass(String pass) {
        this.pass = pass;
    }
    public String getNick() {
        return this.nick;
    }
    
    public void setNick(String nick) {
        this.nick = nick;
    }
    public Set getTokenses() {
        return this.tokenses;
    }
    
    public void setTokenses(Set tokenses) {
        this.tokenses = tokenses;
    }
    public Set getQuestionses() {
        return this.questionses;
    }
    
    public void setQuestionses(Set questionses) {
        this.questionses = questionses;
    }

    @Override
    public String toString() {
        return "Users{" + "idUser=" + idUser + ", mail=" + mail + ", pass=" + pass + ", nick=" + nick + ", tokenses=" + tokenses + ", questionses=" + questionses + '}';
    }

    


}


