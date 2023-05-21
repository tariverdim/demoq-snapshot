package com.example.demoq.model;

import org.springframework.lang.NonNull;

public class UserDto {

    @NonNull
    private String userName;

    @NonNull
    private String password;

    @NonNull
    private String matchingPassword;

    @NonNull
    private String email;

    public UserDto(@NonNull String userName, @NonNull String password, @NonNull String matchingPassword, @NonNull String email) {

        this.userName = userName;
        this.password = password;
        this.matchingPassword = matchingPassword;
        this.email = email;
    }

    public UserDto() {
    }

    @NonNull
    public String getUserName() {
        return userName;
    }

    public void setUserName(@NonNull String userName) {
        this.userName = userName;
    }

    @NonNull
    public String getPassword() {
        return password;
    }

    public void setPassword(@NonNull String password) {
        this.password = password;
    }

    @NonNull
    public String getMatchingPassword() {
        return matchingPassword;
    }

    public void setMatchingPassword(@NonNull String matchingPassword) {
        this.matchingPassword = matchingPassword;
    }

    @NonNull
    public String getEmail() {
        return email;
    }

    public void setEmail(@NonNull String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", matchingPassword='" + matchingPassword + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
