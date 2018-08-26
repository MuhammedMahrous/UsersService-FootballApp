package com.mahrous.footballapp.users.payload.response;

import com.mahrous.footballapp.users.model.entity.util.PlayerType;

public class BasicPlayer {
    private String firstName;
    private String lastName;
    private String userName;
    private String email;
    private String password;
    private PlayerType playerType;

    public BasicPlayer() {
    }

    public BasicPlayer(String firstName, String lastName, String userName, String email, String password, PlayerType playerType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.email = email;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }
}
