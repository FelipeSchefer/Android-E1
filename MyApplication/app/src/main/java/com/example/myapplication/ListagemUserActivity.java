package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Arrays;

public class ListagemUserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listagem_user);

        ArrayList<User> listaUser = (ArrayList<User>) getIntent().getSerializableExtra("lista_user");

        ListView listView = findViewById(R.id.listViewUser);
        AdapterUserListagem adapterUserListagem =
                new AdapterUserListagem(this, listaUser);

        listView.setAdapter(adapterUserListagem);
    }

}
