package com.servicedemo.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@ApiModel(description = "User model class description ")
public class User {

    private Long userId;

    @Size(min = 2, message = "Name should have more then 2 char length ")
    @ApiModelProperty(notes = "User name should have minimum 2 characters ")
    private String userName;

    @Past(message = "Future date can not be possible for DOB")
    @ApiModelProperty(notes = "Future date of birth is not possible ")
    private Date dateOfBirth;

    public User() {
    }

    public User(Long userId, String userName, Date dateOfBirth) {
        this.userId = userId;
        this.userName = userName;
        this.dateOfBirth = dateOfBirth;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (userId != null ? !userId.equals(user.userId) : user.userId != null) return false;
        return userName != null ? userName.equals(user.userName) : user.userName == null;
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}
