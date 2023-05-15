package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class DashBoardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        String login = (String)getIntent().getSerializableExtra("login");

        Toast.makeText(this,"Seja bem vindo, querido " + login,Toast.LENGTH_LONG).show();
    }
}