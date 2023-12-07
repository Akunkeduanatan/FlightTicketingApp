package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class    RegisterActivity extends AppCompatActivity {
    private TextInputEditText username;
    private TextInputEditText email;
    private TextInputEditText password;
    private MaterialButton btnregister;
    private TextView logintext; // Correctly scoped field

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        username = findViewById(R.id.inputUser); // Correct ID for username
        email = findViewById(R.id.inputEmail); // Correct ID for email
        password = findViewById(R.id.inputPassword);
        btnregister = findViewById(R.id.btnRegister);
        logintext = findViewById(R.id.logintext); // Assigning to the field, not a local variable

        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerNewUser();
            }
        });

        logintext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), LoginActivity.class);
                view.getContext().startActivity(intent);
            }
        });

    }

    private void registerNewUser(){
        // This method should be outside onCreate method but within the class body.
        String usernameinput = username.getText().toString().trim();
        String emailinput = email.getText().toString().trim();
        String passwordinput = password.getText().toString().trim();

        if(usernameinput.isEmpty()){
            Toast.makeText(this, "Username tidak boleh kosong !",Toast.LENGTH_SHORT).show();
            return;
        }
        if(passwordinput.isEmpty()){
            Toast.makeText(this, "Password tidak boleh kosong !", Toast.LENGTH_SHORT).show();
            return;
        }
        if(emailinput.isEmpty()){
            Toast.makeText(this, "Email tidak boleh kosong !", Toast.LENGTH_SHORT).show();
            return;
        }
        UserManager.addUser(new User(usernameinput, passwordinput, emailinput));
        Toast.makeText(this, "Pendaftaran berhasil !", Toast.LENGTH_SHORT).show();

        Intent loginIntent = new Intent(this, LoginActivity.class);
        startActivity(loginIntent);
        finish();

    }
    }
