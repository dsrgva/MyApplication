package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private EditText email_login;
    private EditText password;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email_login = findViewById(R.id.edEmail);
        password = findViewById(R.id.edPassword);

        mAuth = FirebaseAuth.getInstance();

        Button buttonStart = (Button)findViewById(R.id.buttonStart);

        buttonStart.setOnClickListener(new View.OnClickListener() {
                                           @Override
       public void onClick(View view) {
           if (email_login.getText().toString().isEmpty() || password.getText().toString().isEmpty()) {
               Toast.makeText(MainActivity.this, "Введите e-mail и пароль", Toast.LENGTH_LONG).show();
           } else {
               mAuth.signInWithEmailAndPassword(email_login.getText().toString(), password.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                   @Override
                   public void onComplete(@NonNull Task<AuthResult> task) {
                       if (task.isSuccessful()) {
                           Intent intent = new Intent(MainActivity.this, GameLevels.class);
                           startActivity(intent);
                           finish();
                       } else {
                           Toast.makeText(MainActivity.this, "Что-то пошло не так", Toast.LENGTH_LONG).show();
                       }
                   }
               });
           }
       }
   });


        Button buttonReg1 = (Button)findViewById(R.id.buttonReg1);

        buttonReg1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    Intent intent = new Intent(MainActivity.this, Registr.class);
                    startActivity(intent); finish();
                }
                catch (Exception e){

                }
            }
        });

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
}