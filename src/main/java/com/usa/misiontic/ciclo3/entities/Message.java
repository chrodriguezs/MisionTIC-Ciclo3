package com.usa.misiontic.ciclo3.entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@Entity
@Table(name = "message")
public class Message implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMessage;
    private String messageText;

    @ManyToOne
    @JoinColumn(name = "quadbikeId")
    @JsonIgnoreProperties({"messages","reservations"})
    private Quadbike quadbike;
 
    @ManyToOne
    @JoinColumn(name = "clientId")
    @JsonIgnoreProperties({"messages","reservations"})
    private Client client;

    public Integer getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(Integer id) {
        this.idMessage = id;
    }
 
    public Quadbike getQuadbike() {
        return this.quadbike;
    }

    public void setQuadbikes(Quadbike quadbike) {
        this.quadbike = quadbike;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public void setQuadbike(Quadbike quadbike) {
        this.quadbike = quadbike;
    }

    
    
}
