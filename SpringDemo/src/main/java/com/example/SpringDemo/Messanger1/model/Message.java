package com.example.SpringDemo.Messanger1.model;

import jakarta.persistence.*;

import java.util.Date;
@Entity
@Table(name = "Messages")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    int messageId;
    @Column(name = "Message")
    String message;
    @Column(name = "Author")
    String author;
    Date date;


    public Message(){

    }
    public Message(String message, String author){
        this.message = message;
        this.author = author;
    }

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int id) {
        this.messageId = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "{" +
                "\"messageId\":" + messageId +
                ", \"message\":\"" + message + '\"' +
                ", \"author\":\"" + author + '\"' +
                ", \"date\":" + date +
                '}';
    }

}
