package com.example.estudos_android_studio.model;

import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {

    private final static List<Aluno> alunos = new ArrayList<>();
    private static int contadorDeIds = 1;

    // Metodo de salvamento de aluno
    public void salva(Aluno aluno) {
        aluno.setId(contadorDeIds);
        alunos.add(aluno);
        contadorDeIds++;
    }

    public void edita(Aluno aluno){
        Aluno alunoEncontrado = null;
        for (Aluno a :alunos){
            if(a.getId() == aluno.getId()){
                alunoEncontrado = a;
            }
        }
        if (alunoEncontrado != null){
           int posicaoDoAluno = alunos.indexOf(alunoEncontrado);
           alunos.set(posicaoDoAluno, aluno);
        }
    }

    // Retorno de lista de Alunos
    public List<Aluno> todos() {
        return new ArrayList<>(alunos);
    }

}
