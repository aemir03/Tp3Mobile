package com.example.tp3p1.database;

import com.example.tp3p1.model.Score;
import com.example.tp3p1.model.User;

import java.sql.Date;
import java.util.List;

public class DataInsertion {

    private DatabaseManager databaseManager;
    private User u1;
    private User u2;

    private void insertUsers(){
        u1 = new User("Aemir","Boulmerka","emirboulerka@gmail.com","12345","CANADA");
        u2 = new User("Lawrence","Lefebvre","lawrenceLefebvre@gmail.com","12345","FRANCE");
        databaseManager.insertUser(u1);
        databaseManager.insertUser(u2);
    }

    private void insertScores(){
        Score s1 = new Score(u1, 5);
        Score s2 = new Score(u2, 10);
        databaseManager.insertScore(s1);
        databaseManager.insertScore(s2);
    }

    public DataInsertion(DatabaseManager databaseManager) {
        this.databaseManager = databaseManager;
        insertUsers();
        insertScores();

        List<Score> scores= databaseManager.readScoresOrderBy();
        for (Score s: scores) {
            System.out.println(s);
        }
    }
}
