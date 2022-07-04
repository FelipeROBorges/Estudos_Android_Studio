package com.example.estudos_android_studio.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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

        // Definindo o nome exibido na parte superior da tela
        setTitle("Lista de Alunos");

        // Mensagem de entrada do app
        Toast.makeText(this, "Bem-vindo!", Toast.LENGTH_LONG).show();

        // Direcionando o usuário para a tela de cadastro
        View botaoNovoAluno = findViewById(R.id.activity_lista_alunos_fab_novo_aluno);
        botaoNovoAluno.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startActivity(new Intent(ListaAlunosActivity.this,
                        FormularioAlunoActivity.class));
            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();

        // Instanciando classe DAO
        AlunoDAO dao = new AlunoDAO();

        // Implementando lista de alunos com classe DAO
        ListView listaDeAlunos = findViewById(R.id.activity_lista_alunos_lista_de_alunos);
        listaDeAlunos.setAdapter(new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                dao.todos()));
    }
}