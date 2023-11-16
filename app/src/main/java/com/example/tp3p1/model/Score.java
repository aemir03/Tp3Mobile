package com.example.tp3p1.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;


@DatabaseTable( tableName = "T_Score" )
public class Score {

    @DatabaseField( columnName = "idScore", generatedId = true )
    private int idScore;

    @DatabaseField( foreign = true, foreignAutoRefresh = true, foreignAutoCreate = true, foreignColumnName = "idUser")
    private User user;

    @DatabaseField
    private int nbEssais;

    @DatabaseField
    private Date date;

    public Score(){}

    public Score(User user, int nbEssais, Date date) {
        this.user = user;
        this.nbEssais = nbEssais;
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getNbEssais() {
        return nbEssais;
    }

    public void setNbEssais(int nbEssais) {
        this.nbEssais = nbEssais;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
