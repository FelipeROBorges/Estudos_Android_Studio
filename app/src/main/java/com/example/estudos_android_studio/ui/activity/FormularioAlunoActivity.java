package com.example.estudos_android_studio.ui.activity;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import com.example.estudos_android_studio.R;
import com.example.estudos_android_studio.model.Aluno;
import com.example.estudos_android_studio.model.AlunoDAO;

public class FormularioAlunoActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Novo Aluno";
    AlunoDAO dao = new AlunoDAO();
    private EditText campoNome;
    private EditText campoEmail;
    private EditText campoTelefone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_aluno);
        setTitle(TITULO_APPBAR);
        inicializaCampos();
        salvaAluno();

        // Pegando dados passados pelo putExtra atravez de um Intent
        Intent dados = getIntent();
        Aluno aluno = (Aluno) dados.getSerializableExtra("aluno");

        // Pegando os valores contidos no objeto aluno
        campoNome.setText(aluno.getNome());
        campoTelefone.setText(aluno.getTelefone());
        campoEmail.setText(aluno.getEmail());
    }

    private void salvaAluno() {
        View botaoSalvar = findViewById(R.id.activity_formulario_aluno_butao_salvar);
        botaoSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Aluno alunoCriado = getAluno();
            dao.salva(alunoCriado);
            finish();
            }
        });
    }

    private void inicializaCampos() {
        campoNome = findViewById(R.id.activity_formulario_aluno_nome);
        campoEmail = findViewById(R.id.activity_formulario_aluno_email);
        campoTelefone = findViewById(R.id.activity_formulario_aluno_telefone);
    }

    @NonNull
    private Aluno getAluno() {
        String nome = campoNome.getText().toString();
        String email = campoEmail.getText().toString();
        String telefone = campoTelefone.getText().toString();
        Aluno alunoCriado = new Aluno (nome, telefone, email);
        return alunoCriado;

    }

}