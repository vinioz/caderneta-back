package com.ufpb.dsc.caderneta.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ufpb.dsc.caderneta.model.Professor;


public interface ProfessorRepository extends CrudRepository<Professor,Integer>{

	

	
	/**
	 * Insere um professor dado uma turma existente.
	 * @param cpf
	 * @param nome
	 * @param codturma
	 * @param turma_id
	 * @return
	 */
	@Modifying
	@Transactional
	@Query(value = "insert into professor (cpf,nome,codturma,turma_id) values (:cpf,:nome:codturma,:turma_id)",nativeQuery=true)
	boolean addProfessor(@Param("cpf") String cpf, @Param("nome") String nome, @Param("codturma") String codturma, @Param("turma_id") Integer turma_id);
	


	


}
