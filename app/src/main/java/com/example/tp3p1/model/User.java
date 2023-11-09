package com.example.tp3p1.model;


import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import java.util.Date;


@DatabaseTable( tableName = "T_User" )
public class User {

    @DatabaseField( columnName = "idUser", generatedId = true )
    private int idUser;

    @DatabaseField
    private String firstName;

    @DatabaseField
    private String lastName;

    @DatabaseField
    private String pays;

    @DatabaseField
    private String email;

    public User(){

    }
    public User(String firstName, String lastName, String email, String pays) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.pays = pays;
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

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
