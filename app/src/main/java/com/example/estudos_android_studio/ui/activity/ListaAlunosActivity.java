package com.example.estudos_android_studio.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import com.example.estudos_android_studio.R;
import com.example.estudos_android_studio.model.Aluno;
import com.example.estudos_android_studio.model.AlunoDAO;

import java.util.List;

public class ListaAlunosActivity extends AppCompatActivity {

    public static final String TITLE_APPBAR = "Lista de Alunos";
    private final AlunoDAO dao = new AlunoDAO();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_alunos);
        setTitle(TITLE_APPBAR);
        Toast.makeText(this, "Bem-vindo!", Toast.LENGTH_LONG).show();
        configuraFabNovoAluno();
        dao.salva(new Aluno("Felipe", "1122223333", "felipe@lokomail.com"));
    }

    private void configuraFabNovoAluno() {
        View botaoNovoAluno = findViewById(R.id.activity_lista_alunos_fab_novo_aluno);
        botaoNovoAluno.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                abreFormularioAluno();
            }
        });
    }

    private void abreFormularioAluno() {
        startActivity(new Intent(this,
                FormularioAlunoActivity.class));
    }

    @Override
    protected void onResume() {
        super.onResume();
        configuraAluno();
    }

    private void configuraAluno() {
        ListView listaDeAlunos = findViewById(R.id.activity_lista_alunos_lista_de_alunos);

        // Designando uma variavel para o array de alunos
        final List<Aluno> alunos = dao.todos();

        listaDeAlunos.setAdapter(new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                alunos));

        // Definindo ação ao clicar na lista de alunos
        listaDeAlunos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posicao, long id) {
                Aluno alunoEscolhido = alunos.get(posicao);

                // Enviando informações para o logcat do android studio
                Log.i("Aluno:", "" + alunoEscolhido);

                // Enviado mensagem de confirmação de clique
                Toast.makeText(ListaAlunosActivity.this, "Clique Funcionando.", Toast.LENGTH_SHORT).show();

                // Implmentando Intent para levar a outra página
                Intent vaiParaFormularioAlunoActivity =
                        new Intent(ListaAlunosActivity.this,
                                FormularioAlunoActivity.class);

                // Enviando informações atravez do putExtra para a Activity de destino
                vaiParaFormularioAlunoActivity.putExtra("aluno", alunoEscolhido);

                startActivity(vaiParaFormularioAlunoActivity);
            }
        });
        };
    }

