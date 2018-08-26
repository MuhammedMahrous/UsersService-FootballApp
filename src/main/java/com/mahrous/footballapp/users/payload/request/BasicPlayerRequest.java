package com.mahrous.footballapp.users.payload.request;

import com.mahrous.footballapp.users.model.entity.util.PlayerType;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class BasicPlayerRequest {

    @NotBlank(message = "First name is not valid")
    private String firstName;

    @NotBlank(message = "Last name is not valid")
    private String lastName;

    @NotBlank(message = "Username is not valid")
    private String userName;

    @NotBlank(message = "Email is not valid")
    private String email;

    @NotBlank(message = "Password is not valid")
    private String password;

    @NotNull(message = "Player type is not valid")
    private PlayerType playerType;

    public BasicPlayerRequest() {
    }

    public BasicPlayerRequest(String firstName, String lastName, String userName, String email, String password, PlayerType playerType) {
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

    @Override
    public String toString() {
        return "BasicPlayerRequest{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", playerType=" + playerType +
                '}';
    }
}
