package com.agenda.contatos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.agenda.contatos.model.ContatosModel;
import com.agenda.contatos.repository.ContatosRepository;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;






@RestController
@RequestMapping("/api/contatos")
@AllArgsConstructor
public class ContatosController {

    @Autowired
    private ContatosRepository contatosRepository;
    
    @GetMapping
    public List<ContatosModel> list(){
        return contatosRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContatosModel> findById(@PathVariable Long id){
        return contatosRepository.findById(id)
            .map(recordFound -> ResponseEntity.ok().body(recordFound))
                .orElse(ResponseEntity.notFound().build());
    }

    
    

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public ContatosModel create(@RequestBody ContatosModel contatos) {
        return contatosRepository.save(contatos);
    }


    @PutMapping("/{id}")
    private ResponseEntity<ContatosModel> update(@PathVariable Long id,
        @RequestBody ContatosModel contatos){
        return contatosRepository.findById(id)
        .map(recordFound -> {
            recordFound.setNome(contatos.getNome());
            recordFound.setTelefone(contatos.getTelefone());
            recordFound.setEmail(contatos.getEmail());
            ContatosModel updated = contatosRepository.save(recordFound);
            return ResponseEntity.ok().body(updated);
        })

            .orElse(ResponseEntity.notFound().build());
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        return contatosRepository.findById(id)
        .map(recordFound -> {
            contatosRepository.deleteById(id);
            return ResponseEntity.noContent().<Void>build();
            
        })
            .orElse(ResponseEntity.notFound().build());
    }

}
