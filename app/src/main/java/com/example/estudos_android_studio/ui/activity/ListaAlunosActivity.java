package com.example.estudos_android_studio.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.estudos_android_studio.R;
import com.example.estudos_android_studio.model.AlunoDAO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListaAlunosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Fazendo o link com um arquivo DML de visualização
        setContentView(R.layout.activity_lista_alunos);

        // Instanciando classe DAO
        AlunoDAO dao = new AlunoDAO();

        // Definindo o nome exibido na parte superior da tela
        setTitle("Lista de Alunos");

        // Mensagem de entrada do app
        Toast.makeText(this, "Bem-vindo!", Toast.LENGTH_LONG).show();

        // Implementando lista de alunos com classe DAO
        ListView listaDeAlunos = findViewById(R.id.activity_lista_alunos_lista_de_alunos);
        listaDeAlunos.setAdapter(new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                dao.todos()));
    }
}