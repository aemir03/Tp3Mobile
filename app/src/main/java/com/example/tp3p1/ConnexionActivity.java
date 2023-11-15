package com.example.tp3p1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;

import com.example.tp3p1.database.DataInsertion;
import com.example.tp3p1.database.DatabaseManager;
import com.example.tp3p1.model.User;
import com.google.android.material.textfield.TextInputEditText;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConnexionActivity extends AppCompatActivity {

    private Button buttonCreationCompte;
    private Button buttonConnexion;
    private TextInputEditText pwdInput;
    private TextInputEditText emailInput;
    private Pattern emailPattern;

    private DatabaseManager databaseManager;

    public void inscription(Intent intent){
        buttonCreationCompte = findViewById(R.id.buttonCreationCompte);
        buttonCreationCompte.setOnClickListener(v -> {
            startActivity(intent);
        });
    }

    public boolean validatePwd(String pwd){
        return pwd.length() >= 5;
    }
    public boolean validateEmail(String email){
        Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile(getResources().getString(R.string.regexForMail), Pattern.CASE_INSENSITIVE);
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
        return matcher.find();
    }
    public void watcherTxt(EditText input){
        input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(!validateEmail(editable.toString())){
                    emailInput.setError(getResources().getString(R.string.noValideMail));
                }
                if(!validatePwd(editable.toString())){
                    pwdInput.setError(getResources().getString(R.string.noValidePwd));
                }
            }
        });
    }

    private boolean checkIfUserExist(String emailUser, String pwdUser){
        List<User> users = databaseManager.readUsers();
        return users.stream().anyMatch(u -> u.getEmail().equals(emailUser) && u.getPwd().equals(pwdUser));
    }

    private void connexionToDbUser(Button cnxBtn, Intent intent){
        cnxBtn.setOnClickListener((click)->{
            String emailUser = emailInput.getText().toString();
            String pwdUser = pwdInput.getText().toString();
            if(checkIfUserExist(emailUser, pwdUser)){
                startActivity(intent);
            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion);

        databaseManager = new DatabaseManager( this );
        new DataInsertion(databaseManager);

        inscription(new Intent(this, InscriptionActivity.class));
        emailPattern  = Pattern.compile(getResources().getString(R.string.regexForMail));
        emailInput = findViewById(R.id.courrielInput);
        pwdInput = findViewById(R.id.pwdInput);
        buttonConnexion = findViewById(R.id.buttonConnexion);

        watcherTxt(emailInput);
        watcherTxt(pwdInput);
        connexionToDbUser(buttonConnexion, new Intent(this, MainActivity.class));

    }
}