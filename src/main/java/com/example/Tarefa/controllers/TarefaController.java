package com.example.Tarefa.controllers;

import com.example.Tarefa.models.TarefaModel;
import com.example.Tarefa.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/tarefas")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @PostMapping
    public TarefaModel criarTarefa(TarefaModel novaTarefa){
        return tarefaService.criarTarefa(novaTarefa);
    }

    @GetMapping
    public List<TarefaModel> listarTodos(){
        return tarefaService.listarTodos();
    }

    @DeleteMapping("/{id}")
    public void deletarTarefa(Long id){
        tarefaService.deletarTarefa(id);
    }

    @GetMapping("/{id}")
    public Optional<TarefaModel> buscarPorId(Long id){
        return tarefaService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public TarefaModel atualizarTarefa(@PathVariable Long id, @RequestBody TarefaModel novaTarefa){
        return tarefaService.atualizarTarefa(id, novaTarefa);
    }
}
