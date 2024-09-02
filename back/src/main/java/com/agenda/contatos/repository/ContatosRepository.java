package com.agenda.contatos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.agenda.contatos.model.ContatosModel;

@Repository
public interface ContatosRepository extends JpaRepository<ContatosModel,Long>{
    


}
