package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {

    ArrayList<User> userList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void listarUser(View view){
        Bundle bundle = new Bundle();
        bundle.putSerializable("lista_user", userList);
        Intent intent = new Intent(this,ListagemUserActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void logar(View view) {
        EditText login = findViewById(R.id.editTextLogin);
        EditText senha = findViewById(R.id.editTextSenha);

        if(userList.size() == 0){
            Toast.makeText(this, "Usuario não encontrado", Toast.LENGTH_LONG).show();
        }

        for(User user: userList){
            if(login.getText().toString().equals("")){
                Toast.makeText(this,"Seu login está incorreto",Toast.LENGTH_LONG).show();
            }
            if (senha.getText().toString().equals("")) {
                Toast.makeText(this,"Sua senha está incorreta",Toast.LENGTH_LONG).show();
            }
            if(login.getText().toString().equals(user.getEmail())){
                if(senha.getText().toString().equals(user.getSenha()) &&
                   login.getText().toString().equals(user.getEmail())){
                    Bundle bundle = new Bundle();
                    bundle.putString("login",login.getText().toString());
                    Intent intent = new Intent(this, DashBoardActivity.class);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }else{
                    Toast.makeText(this,"Usuário ou Senha está inválido",Toast.LENGTH_LONG).show();
                }
            }
        }
        login.setText("");
        senha.setText("");
    }
    public void abrirCadastroUsuario(View view) {
        Intent intent = new Intent(this, CadastraUsuarioActivity.class);
        startActivityForResult(intent,Constantes.RESULT_OK);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if(resultCode == Constantes.RESULT_OK){
            User user = (User) data.getExtras().get("user");
            userList.add(user);
        }

        super.onActivityResult(requestCode,resultCode,data);
    }
}