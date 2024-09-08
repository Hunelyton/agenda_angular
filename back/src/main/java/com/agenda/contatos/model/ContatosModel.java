package com.agenda.contatos.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "contatos")
@Getter
@Setter
public class ContatosModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(nullable = false)
    private Long id;


    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, length = 11, unique = true)
    private String telefone;

    @Column(nullable = true, length = 100)
    private String email;

    

}
