package com.example.estudos_android_studio.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.estudos_android_studio.R;
import com.example.estudos_android_studio.model.Aluno;
import com.example.estudos_android_studio.model.AlunoDAO;

public class FormularioAlunoActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_aluno);


        AlunoDAO dao = new AlunoDAO();

        // Fazendo o tacking das view fornecidas pela interface visual
        // Importante na utilização de classes anônimas deixar os valores como final, caso contrario,
        // não havera compilação
        final EditText campoNome = findViewById(R.id.activity_formulario_aluno_nome);
        final EditText campoEmail = findViewById(R.id.activity_formulario_aluno_email);
        final EditText campoTelefone = findViewById(R.id.activity_formulario_aluno_telefone);


        // Setando ação executada ao clicar no botão
        // Chamando classe anônima
        View botaoSalvar = findViewById(R.id.activity_formulario_aluno_butao_salvar);
        botaoSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             // Pegando os valores das edittext e atribuindo a variavaveis
             String nome = campoNome.getText().toString();
             String email = campoEmail.getText().toString();
             String telefone = campoTelefone.getText().toString();

             // Criando um objeto para armazenar as informações
             Aluno alunoCriado = new Aluno (nome, telefone, email);

            // Chamando metodo de salvamento de Aluno
            dao.salva(alunoCriado);

            // Enviando o Aluno para a clase DAO
            startActivity(new Intent(FormularioAlunoActivity.this,
                    ListaAlunosActivity.class));

            }
        });

    }
}