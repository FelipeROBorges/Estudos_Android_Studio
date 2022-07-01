package com.example.estudos_android_studio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Mensagem de entrada do app
        Toast.makeText(this, "Bem-vindo!", Toast.LENGTH_LONG).show();

        // Implementando lista de Alunos
        List<String> alunos = new ArrayList<>(Arrays.asList("Felipe", "Lucas", "Caio", "Diego", "Felix"));

        // Implementando lista de alunos com ListView e ArrayAdapter
        ListView listaDeAlunos = findViewById(R.id.lista_de_alunos);
        listaDeAlunos.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                alunos));
    }
}