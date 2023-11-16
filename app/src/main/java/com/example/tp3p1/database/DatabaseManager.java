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
            TableUtils.createTableIfNotExists( connectionSource, Score.class );
            TableUtils.createTableIfNotExists( connectionSource, User.class );
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

    /**
     * Pour inserer le score dans la database
     * @param score
     */
    public void insertScore(Score score) {
        try {
            Dao<Score, Integer> dao = getDao(Score.class);
            dao.createOrUpdate(score);
            Log.i("DATABASE", "InsertScore invoked");
        } catch (Exception exception) {
            Log.e("DATABASE", "Can't insert score into Database", exception);
        }
    }

    /**
     * Pour lire les scores dans la database dans l'ordre decroissant
     * @return
     */
    public List<Score> readScoresOrderBy() {
        try {
            Dao<Score, Integer> dao = getDao(Score.class);
            List<Score> scores = dao.queryBuilder().orderBy("nbEssais", true).query();
            Log.i("DATABASE", "readScores invoked");
            return scores;
        } catch (Exception exception) {
            Log.e("DATABASE", "Can't insert score into Database", exception);
            return null;
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

    /**
     * Pour lire l'utilisateur dans la database
     * @param email
     * @return
     */
    public User readUser(String email) {
        try {
            Dao<User, Integer> dao = getDao(User.class );
            User user = dao.queryBuilder().where().eq("email", email).queryForFirst();
            Log.i( "DATABASE", "readScores invoked" );
            return user;
        } catch( Exception exception ) {
            Log.e( "DATABASE", "Can't insert score into Database", exception );
            return null;
        }
    }
}
