package com.agenda.contatos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agenda.contatos.model.ContatosModel;
import com.agenda.contatos.repository.ContatosRepository;

import lombok.AllArgsConstructor;



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
}
