package com.example.estudos_android_studio.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.estudos_android_studio.R;

public class FormularioAlunoActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_aluno);

        // Fazendo o tacking das view fornecidas pela interface visual
        EditText campoEmail = findViewById(R.id.activity_formulario_aluno_email);
        EditText campoNome = findViewById(R.id.activity_formulario_aluno_nome);
        EditText campoTelefone = findViewById(R.id.activity_formulario_aluno_telefone);

        // Setando ação executada ao clicar no botão
        View botaoSalvar = findViewById(R.id.activity_formulario_aluno_butao_salvar);
        botaoSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(FormularioAlunoActivity.this,
                        "Click no botão salvar!",
                        Toast.LENGTH_LONG).show();
            }
        });

    }
}