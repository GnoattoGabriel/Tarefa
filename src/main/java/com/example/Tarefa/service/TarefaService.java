package com.example.Tarefa.service;


import com.example.Tarefa.models.TarefaModel;
import com.example.Tarefa.repositories.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;


    public TarefaModel criarTarefa(TarefaModel novaTarefa){
        return tarefaRepository.save(novaTarefa);
    }

    public List<TarefaModel> listarTodos(){
        return tarefaRepository.findAll();
    }

    public void deletarTarefa(Long id){
        tarefaRepository.deleteById(id);
    }

    public Optional<TarefaModel> buscarPorId(Long id){
        return tarefaRepository.findById(id);
    }

    public TarefaModel atualizarTarefa(Long id, TarefaModel novaTarefa){
        Optional<TarefaModel> tarefaBanco = tarefaRepository.findById(id);

        if(tarefaBanco.isPresent()){
            TarefaModel tarefaEdit = tarefaBanco.get();

            tarefaEdit.setDescricao(novaTarefa.getDescricao());
            tarefaEdit.setConcluida(novaTarefa.getConcluida());
            tarefaEdit.setDataVencimento(novaTarefa.getDataVencimento());

            return tarefaRepository.save(tarefaEdit);

        } else return null;
    }

}
