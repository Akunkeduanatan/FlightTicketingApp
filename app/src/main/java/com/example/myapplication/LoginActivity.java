package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ButtonBarLayout;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import org.w3c.dom.Text;

public class LoginActivity extends AppCompatActivity {

    MaterialButton btnRegister;
    private TextInputEditText username;
    private TextInputEditText password;
    private MaterialButton btnlogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = findViewById(R.id.inputUser);
        password = findViewById(R.id.inputPassword);
        btnlogin = findViewById(R.id.btnLogin);
        MaterialButton btnRegister = (MaterialButton) findViewById(R.id.btnRegister);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), RegisterActivity.class);
                view.getContext().startActivity(intent);
            }
        });
    }

    private void login() {
        String usernameinput = username.getText().toString().trim();
        String passwordinput = password.getText().toString().trim();

        User user = UserManager.getUser(usernameinput);
        if (user != null && user.getPassword().equals(passwordinput)) {
            Toast.makeText(this, "Login berhasil !", Toast.LENGTH_SHORT).show();
            Intent login = new Intent(this,HomeActivity.class);
            startActivity(login);
            finish();
        } else {
            Toast.makeText(this, "Username atau password salah !", Toast.LENGTH_SHORT).show();
        }

    }
}
