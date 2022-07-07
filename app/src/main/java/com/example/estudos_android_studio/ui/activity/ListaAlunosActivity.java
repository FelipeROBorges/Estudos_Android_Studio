package com.example.estudos_android_studio.ui.activity;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
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

    // Adicionando menu de contexto quando é feito o click longo, subistituindo o click longo
    // de remoção
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add("Remover");
    }

    // Implentando ação ao clicar no item de menu info
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        // Adicionando um Adapter para o menu de contexto
        AdapterView.AdapterContextMenuInfo menuInfo =
                (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        // Pegando a posição do aluno e removendo o mesmo
        Aluno alunoEscolhido = adapter.getItem(menuInfo.position);
        removeAluno(alunoEscolhido);
        return super.onContextItemSelected(item);
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
        adapter.clear();
        adapter.addAll(dao.todos());
    }

    private void configuraAluno() {
        ListView listaDeAlunos = findViewById(R.id.activity_lista_alunos_lista_de_alunos);
        configuraAdapter(listaDeAlunos);
        configuraListenerDeCliquePorItem(listaDeAlunos);
        registerForContextMenu(listaDeAlunos);
    }


    private void removeAluno(Aluno alunoEscolhido) {
        dao.remover(alunoEscolhido);
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
}