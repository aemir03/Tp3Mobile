package com.example.tp3p1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.tp3p1.adapters.UserAdapter;
import com.example.tp3p1.database.DatabaseManager;
import com.example.tp3p1.model.User;

import java.util.ArrayList;

public class ScoreActivity extends AppCompatActivity {

    private DatabaseManager databaseManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        databaseManager = new DatabaseManager( this );

        ArrayList<User> userList = new ArrayList<>();

        // Dans votre activité ou fragment
        UserAdapter adapter = new UserAdapter(this, databaseManager.readScoresOrderBy());

        ListView listView = findViewById(R.id.listScoreView);
        listView.setAdapter(adapter);
    }
}