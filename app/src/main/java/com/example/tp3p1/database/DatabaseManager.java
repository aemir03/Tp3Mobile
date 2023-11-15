package com.example.tp3p1.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.tp3p1.model.Score;
import com.example.tp3p1.model.User;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.util.List;

public class DatabaseManager extends OrmLiteSqliteOpenHelper {

    private static final String DATABASE_NAME = "Game.db";
    private static final int DATABASE_VERSION = 2;

    public DatabaseManager( Context context ) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            //TableUtils.createTable( connectionSource, Score.class );
            TableUtils.createTable( connectionSource, User.class );
            Log.i( "DATABASE", "onCreate invoked" );
        } catch( Exception exception ) {
            Log.e( "DATABASE", "Can't create Database", exception );
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            TableUtils.dropTable( connectionSource, Score.class, true );
            TableUtils.dropTable( connectionSource, User.class, true );
            onCreate( database, connectionSource);
            Log.i( "DATABASE", "onUpgrade invoked" );
        } catch( Exception exception ) {
            Log.e( "DATABASE", "Can't upgrade Database", exception );
        }
    }

    /**
     * Pour inserer l'utilisateur dans la database
     * @param user
     */
    public void insertUser(User user) {
        try {
            Dao<User, Integer> dao = getDao(User.class);
            dao.create(user);
            Log.i( "DATABASE", "InsertUser invoked" );
        } catch( Exception exception ) {
            Log.e( "DATABASE", "Can't insert score into Database", exception );
        }
    }

    public List<User> readUsers() {
        try {
            Dao<User, Integer> dao = getDao(User.class );
            List<User> users = dao.queryForAll();
            Log.i( "DATABASE", "readScores invoked" );
            return users;
        } catch( Exception exception ) {
            Log.e( "DATABASE", "Can't insert score into Database", exception );
            return null;
        }
    }
}
