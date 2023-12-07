package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

public class User extends AppCompatActivity {
        private String email;
        private String username;
        private String password;

        public User(String username, String password, String email){
            this.username = username;
            this.email = email;
            this.password = password;
        }

        public String getUsername(){
            return username;
        }
        public String getPassword(){
            return password;
        }
    }

