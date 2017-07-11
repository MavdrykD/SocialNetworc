package com.social_network.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by Дімон on 27.06.2017.
 */
@Entity
public class FriendshipOffer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private User user;

    private boolean acceptTheOffer;

    private LocalDateTime dateOfConfirmation;

    @ManyToOne
    private User friend;

    public FriendshipOffer() {
    }

    public FriendshipOffer(User user, boolean acceptTheOffer, User friend) {
        this.user = user;
        this.acceptTheOffer = acceptTheOffer;
        this.friend = friend;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isAcceptTheOffer() {
        return acceptTheOffer;
    }

    public void setAcceptTheOffer(boolean acceptTheOffer) {
        this.acceptTheOffer = acceptTheOffer;
    }

    public LocalDateTime getDateOfConfirmation() {
        return dateOfConfirmation;
    }

    public void setDateOfConfirmation(LocalDateTime dateOfConfirmation) {
        this.dateOfConfirmation = dateOfConfirmation;
    }

    public User getFriend() {
        return friend;
    }

    public void setFriend(User friend) {
        this.friend = friend;
    }


    @Override
    public String toString() {
        return "FriendshipOffer{" +
                "id=" + id +
                ", user=" + user +
                ", acceptTheOffer=" + acceptTheOffer +
                ", dateOfConfirmation=" + dateOfConfirmation +
                ", friend=" + friend +
                '}';
    }
}
