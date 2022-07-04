package com.example.estudos_android_studio.model;

import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {

    private final static List<Aluno> alunos = new ArrayList<>();

    // Metodo de salvamento de aluno
    public void salva(Aluno aluno) {
        alunos.add(aluno);
    }

    // Retorno de lista de Alunos
    public List<Aluno> todos() {
        return new ArrayList<>(alunos);
    }

}
