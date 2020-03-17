package com.neha.butterknife.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;

import java.io.Serializable;

@Entity
public class Login_Register_Entity implements Serializable {     //one entity to be made coresponding to each table

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name="First Name")
    public String FirstName;

    @ColumnInfo(name="Last Name")
    public String LastName;

    @ColumnInfo(name="Email")
    public String Email;

    @ColumnInfo(name="Password")
    public String Password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }
}
