package com.example.estudos_android_studio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
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
        List<String> alunos = new ArrayList<>(Arrays.asList("Felipe", "Lucas", "Caio"));

        // Encontrando a textView pelo id e atribuindo um valor de acordo como ArrayList
        TextView primeiroAluno = findViewById(R.id.textView);
        TextView segundoAluno = findViewById(R.id.textView2);
        TextView terceiroAluno = findViewById(R.id.textView3);
        primeiroAluno.setText(alunos.get(0));
        segundoAluno.setText(alunos.get(1));
        terceiroAluno.setText(alunos.get(2));
    }
}