package com.example.estudos_android_studio.ui.activity;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import com.example.estudos_android_studio.R;
import com.example.estudos_android_studio.model.Aluno;
import com.example.estudos_android_studio.model.AlunoDAO;

public class ListaAlunosActivity extends AppCompatActivity {

    public static final String TITLE_APPBAR = "Lista de Alunos";
    public static final String CHAVE_ALUNO = "aluno";
    private final AlunoDAO dao = new AlunoDAO();
    private ArrayAdapter<Aluno> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_alunos);
        setTitle(TITLE_APPBAR);
        Toast.makeText(this, "Bem-vindo!", Toast.LENGTH_LONG).show();
        configuraFabNovoAluno();
        configuraAluno();
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
        atualizaAlunos();
    }

    private void atualizaAlunos() {
        // Ao invés de carregar todas as informações de configurção do metodo configuraAluno é
        // mais coerente implementar os metodos do proprio adapter para limpar a visualização e
        // recarregar os Alunos contidos no dao
        adapter.clear();
        adapter.addAll(dao.todos());
    }

    private void configuraAluno() {
        ListView listaDeAlunos = findViewById(R.id.activity_lista_alunos_lista_de_alunos);
        configuraAdapter(listaDeAlunos);
        configuraListenerDeCliquePorItem(listaDeAlunos);

        //Implementando ação ao licar no item por um longo periodo
        configuraListenerDeCliqueLongoPorItem(listaDeAlunos);
    }

    private void configuraListenerDeCliqueLongoPorItem(ListView listaDeAlunos) {
        listaDeAlunos.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int posicao, long id) {
                // Pegando Aluno pela posição
                Aluno alunoEscolhido = (Aluno) adapterView.getItemAtPosition(posicao);
                removeAluno(alunoEscolhido);
                return false;
            }
        });
    }

    private void removeAluno(Aluno alunoEscolhido) {
        // Definindo função de remover alono de acordo com o click longo
        dao.remover(alunoEscolhido);

        // Para melhor experiencia de usuário foi adicionado o uma atualização de estado
        // da Activity logo após sua exclução, por questões de feedback
        // configuraAluno();
        // Solução não viavel pela especificidade do metodo, melhor criar um metodo mais
        // coerente para ataualizar o estaod da Activity

        // No lugar de atualizar a Activity com a função onResume, é mais viavel somente
        // atualizar de forma dinamica atravez do adapterView
        adapter.remove(alunoEscolhido);
    }

    private void configuraListenerDeCliquePorItem(ListView listaDeAlunos) {
        listaDeAlunos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posicao, long id) {
                Aluno alunoEscolhido = (Aluno) adapterView.getItemAtPosition(posicao);
                abreFormularioModoEditaAluno(alunoEscolhido);
            }
        });
    }

    private void abreFormularioModoEditaAluno(Aluno alunoEscolhido) {
        Intent vaiParaFormularioAlunoActivity =
                new Intent(ListaAlunosActivity.this,
                        FormularioAlunoActivity.class);
        vaiParaFormularioAlunoActivity.putExtra(CHAVE_ALUNO, alunoEscolhido);
        startActivity(vaiParaFormularioAlunoActivity);
    }

    private void configuraAdapter(ListView listaDeAlunos) {
        adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1);
        listaDeAlunos.setAdapter(adapter);
    }

    ;
    }

