package com.example.tp3p1.database;

import com.example.tp3p1.model.User;

public class DataInsertion {

    private DatabaseManager databaseManager;

    private void insertUsers(){
        User u1 = new User("Aemir","Boulmerka","emirboulerka@gmail.com","12345","CANADA");
        User u2 = new User("Lawrence","Lefebvre","lawrenceLefebvre@gmail.com","12345","FRANCE");
        databaseManager.insertUser(u1);
        databaseManager.insertUser(u2);
    }

    public DataInsertion(DatabaseManager databaseManager) {
        this.databaseManager = databaseManager;
        insertUsers();
    }
}
