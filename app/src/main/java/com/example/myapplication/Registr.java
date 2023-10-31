package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Registr extends AppCompatActivity {

    private EditText email_reg;
    private EditText password_reg;
    private FirebaseAuth mAuth_reg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);

        email_reg = findViewById(R.id.edEmail1);
        password_reg = findViewById(R.id.edPassword);

        mAuth_reg = FirebaseAuth.getInstance();

        Button buttonRegistr = (Button)findViewById(R.id.buttonReg);

        buttonRegistr.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             if (email_reg.getText().toString().isEmpty() || password_reg.getText().toString().isEmpty()) {
                 Toast.makeText(Registr.this, "Введите e-mail и пароль", Toast.LENGTH_LONG).show();
             } else {
                 mAuth_reg.createUserWithEmailAndPassword(email_reg.getText().toString(), password_reg.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                     @Override
                     public void onComplete(@NonNull Task<AuthResult> task) {
                         if (task.isSuccessful()) {
                             Intent intent = new Intent(Registr.this, MainActivity.class);
                             startActivity(intent);
                             finish();
                         } else {
                             Toast.makeText(Registr.this, "Что-то пошло не так", Toast.LENGTH_LONG).show();
                         }
                     }
                 });
             }
         }
     });

        Button buttonReg10 = (Button)findViewById(R.id.buttonReg3);

        buttonReg10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    Intent intent = new Intent(Registr.this, MainActivity.class);
                    startActivity(intent); finish();
                }
                catch (Exception e){

                }
            }
        });
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
}