package com.simard.adopteunmonstre.model.entities.dto.user;

import java.util.Objects;

public class UserLoginUserNameDto {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String userName) {
        this.username = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserLoginUserNameDto that)) return false;
        return Objects.equals(getUsername(), that.getUsername()) && Objects.equals(getPassword(), that.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUsername(), getPassword());
    }

    @Override
    public String toString() {
        return "UserLoginUserNameDto{" +
                "userName='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
