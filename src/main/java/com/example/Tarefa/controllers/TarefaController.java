package com.example.Tarefa.controllers;

import com.example.Tarefa.models.TarefaModel;
import com.example.Tarefa.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/tarefas")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @PostMapping
    public ResponseEntity<TarefaModel> criarTarefa(@RequestBody TarefaModel novaTarefa){
        TarefaModel tarefa = tarefaService.criarTarefa(novaTarefa);
        return ResponseEntity.status(201).body(tarefa);
    }

    @GetMapping
    public ResponseEntity<List<TarefaModel>> listarTodos(){
        return ResponseEntity.ok(tarefaService.listarTodos());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarTarefa(@PathVariable Long id){
        tarefaService.deletarTarefa(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TarefaModel> buscarPorId(@PathVariable Long id){
        return tarefaService.buscarPorId(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<TarefaModel> atualizarTarefa(@PathVariable Long id, @RequestBody TarefaModel novaTarefa){
        TarefaModel tarefaAtt = tarefaService.atualizarTarefa(id, novaTarefa);
        return ResponseEntity.ok(tarefaAtt);
    }
}
