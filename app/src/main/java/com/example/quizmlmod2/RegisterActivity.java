package com.example.quizmlmod2;

import android.content.Intent;
import android.database.sqlite.SQLiteConstraintException;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.quizmlmod2.data.User;
import com.example.quizmlmod2.data.UserDatabase;
import com.example.quizmlmod2.data.UserDatabaseClient;
import com.example.quizmlmod2.other.SharedPref;

import static com.example.quizmlmod2.other.Utils.isValidEmail;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        ImageView btnBack = findViewById(R.id.imageView);
        EditText etUsername = findViewById(R.id.tietUsername);
        EditText etEmail = findViewById(R.id.tietPassword);
        EditText etPassword = findViewById(R.id.tiePassword);
        Button btnRegister = findViewById(R.id.btnRegister);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
                String username = etUsername.getText().toString();
                String email = etEmail.getText().toString();
                String password = etPassword.getText().toString();

                if (!validateInputs(username,email,password)) return;

                RegisterUserTask registerUserTask = new RegisterUserTask(username,email,password);
                registerUserTask.execute();
            }
        });
    }

    private boolean validateInputs(String username,String email,String password){

        if (username.isEmpty()){
            Toast.makeText(this, getString(R.string.username_cannot_empty), Toast.LENGTH_SHORT).show();
            return false;
        }

        if (email.isEmpty()){
            Toast.makeText(this, getString(R.string.email_cannot_empty), Toast.LENGTH_SHORT).show();
            return false;
        }

        if (!isValidEmail(email)){
            Toast.makeText(this, getString(R.string.email_not_valid), Toast.LENGTH_SHORT).show();
            return false;
        }

        if (password.isEmpty()){
            Toast.makeText(this, getString(R.string.password_cannot_empty), Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    class RegisterUserTask extends AsyncTask<Void, Void, Void> {

        private final String username;
        private final String email;
        private final String password;
        private User user  ;
        private boolean isOkay = true ;

        public RegisterUserTask(String username, String email, String password) {
            this.username = username;
            this.email = email;
            this.password = password;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            UserDatabase databaseClient = UserDatabaseClient.getInstance(getApplicationContext());

            user  = new User(
                    username,   
                    email,
                    password
            );

            try {
                databaseClient.userDao().insertUser(user);
            }catch (SQLiteConstraintException e){
                isOkay =false;
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            if (isOkay){
                Toast.makeText(com.example.quizmlmod2.RegisterActivity.this, "User Created!", Toast.LENGTH_SHORT).show();
                SharedPref sharedPref = SharedPref.getInstance();
                sharedPref.setUser(com.example.quizmlmod2.RegisterActivity.this,user);
                Intent intent = new Intent(com.example.quizmlmod2.RegisterActivity.this,MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }else{
                Toast.makeText(com.example.quizmlmod2.RegisterActivity.this, "This email is already using by someone else", Toast.LENGTH_SHORT).show();
            }

        }
    }

}