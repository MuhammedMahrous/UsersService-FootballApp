package com.mahrous.footballapp.users.payload.response;

import com.mahrous.footballapp.users.model.entity.util.PlayerType;

public class BasicPlayer {
    private String firstName;
    private String lastName;
    private String userName;
    private String email;
    private PlayerType playerType;

    public BasicPlayer() {
    }

    public BasicPlayer(String firstName, String lastName, String userName, String email, PlayerType playerType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.email = email;
        this.playerType = playerType;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }
}
