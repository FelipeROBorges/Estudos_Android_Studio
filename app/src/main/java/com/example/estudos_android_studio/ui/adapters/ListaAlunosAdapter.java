package com.example.estudos_android_studio.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.estudos_android_studio.R;
import com.example.estudos_android_studio.model.Aluno;

import java.util.ArrayList;
import java.util.List;

public class ListaAlunosAdapter extends BaseAdapter {
    private final List<Aluno> alunos = new ArrayList<>();
    private Context context;

    public ListaAlunosAdapter(Context context) {
        this.context = context;
    }

    // Paga a quantidade de itens contidos dentro do array de alunos
    @Override
    public int getCount() {
        return alunos.size();
    }

    // Pega a posição do aluno no array
    @Override
    public Aluno getItem(int posicao) {
        return alunos.get(posicao);
    }

    // Pegar o id do aluno de determinada posição
    @Override
    public long getItemId(int posicao) {
        return alunos.get(posicao).getId();
    }

    // Pega a view relativa ao ao layout do item_aluno, de acordo com o seu viewgroup
    @Override
    public View getView(int posicao, View view, ViewGroup viewGroup) {

        View viewCriada = LayoutInflater
                .from(context)
                .inflate(R.layout.item_aluno, viewGroup,false );

        // Pegando e setando text de acordo com a posição do aluno
        Aluno alunoDevolvido = alunos.get(posicao);
        TextView nome = viewCriada.findViewById(R.id.aluno_nome);
        TextView telefone = viewCriada.findViewById(R.id.aluno_telefone);
        nome.setText(alunoDevolvido.getNome());
        telefone.setText(alunoDevolvido.getTelefone());
        return viewCriada;
    }

    public void clear() {
        alunos.clear();
    }

    public void addAll(List<Aluno> alunos) {
        this.alunos.addAll(alunos);
    }

    public void remove(Aluno aluno) {
        alunos.remove(aluno);
    }
}
