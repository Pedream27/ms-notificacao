package dev.phsaraiva.com.br.ms_agendamento.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_notification")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long notificationID;

    private LocalDateTime dateTime;

    private String destination;

    private String message;
    @ManyToOne
    @JoinColumn(name = "channel_id")
    private Channel channel;
    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Notification() {
    }

    

    public Notification(LocalDateTime dateTime2, String destination2, String message2, Channel channel2,
            Status status2, User user) {
        this.dateTime = dateTime2;
        this.destination = destination2;
        this.message = message2;
        this.channel = channel2;
        this.status = status2;
        this.user = user;
    }



    public long getNotificationID() {
        return notificationID;
    }

    public void setNotificationID(long notificationID) {
        this.notificationID = notificationID;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }



    public User getUser() {
        return user;
    }



    public void setUser(User user) {
        this.user = user;
    }

}
