package com.vinicius.pagamento.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.vinicius.pagamento.model.Titulo;



public interface Tittulos  extends JpaRepository<Titulo, Long >{

	
	public Iterable<Titulo> findByDescricaoContaining(String descricao);
	
}
