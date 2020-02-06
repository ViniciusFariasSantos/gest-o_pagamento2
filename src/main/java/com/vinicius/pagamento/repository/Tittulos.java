package com.vinicius.pagamento.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vinicius.pagamento.model.Titulo;

import antlr.collections.List;

public interface Tittulos  extends JpaRepository<Titulo, Long >{

	
	public ArrayList<Titulo> findByDescricaoContaining(String descricao);
	
}
