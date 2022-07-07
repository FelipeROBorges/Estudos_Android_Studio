package com.example.estudos_android_studio.model;

import android.app.AlertDialog;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.estudos_android_studio.ui.activity.ListaAlunosActivity;

import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {

    private final static List<Aluno> alunos = new ArrayList<>();
    private static int contadorDeIds = 1;

    public void salva(Aluno aluno) {
        aluno.setId(contadorDeIds);
        alunos.add(aluno);
        atualizaIds();
    }

    private void atualizaIds() {
        contadorDeIds++;
    }

    public void edita(Aluno aluno){
        Aluno alunoEncontrado = buscaAlunoPeloId(aluno);
        if (alunoEncontrado != null){
           int posicaoDoAluno = alunos.indexOf(alunoEncontrado);
           alunos.set(posicaoDoAluno, aluno);
        }
    }

    @Nullable
    private Aluno buscaAlunoPeloId(Aluno aluno) {
        for (Aluno a :alunos){
            if(a.getId() == aluno.getId()){
                return a;
            }
        }
        return null;
    }

    public List<Aluno> todos() {
        return new ArrayList<>(alunos);
    }

    public void remover(Aluno aluno) {
        Aluno alunoDevolvido = buscaAlunoPeloId(aluno);
        if(alunoDevolvido != null) {
            alunos.remove(alunoDevolvido);
        }
    }
}
