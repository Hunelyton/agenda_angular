package com.agenda.contatos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import org.springframework.web.bind.annotation.RequestParam;




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
            .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    
    

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public ContatosModel create(@RequestBody ContatosModel contatos) {
        return contatosRepository.save(contatos);
    }

    

}
