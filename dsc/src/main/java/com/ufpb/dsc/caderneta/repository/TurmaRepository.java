package com.ufpb.dsc.caderneta.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ufpb.dsc.caderneta.model.Turma;

/**
 * 
 * @author osval
 *
 */
public interface TurmaRepository extends JpaRepository<Turma, Integer> {
	/**
	 * 
	 * @param codigo
	 * @param creat_at
	 * @param quantidade
	 * @param professor_id
	 */
	@Modifying
	@Transactional
	@Query(value="insert into turma (codigo,creat_at,nome,quantidade_alunos) values (:codigo,:creat_at,:nome,:quantidade_alunos)",nativeQuery=true)
	void addTurma(@Param("codigo") String codigo , @Param("creat_at") String creat_at, @Param("quantidade_alunos") Integer quantidade,
			@Param("nome") String nome);
	/**
	 * 
	 * @param codigo
	 * @return
	 */
	@Query(value="select * from turma where codigo=:codigo",nativeQuery=true)
	Turma checkIfTurmaExistByCod(@Param("codigo") String codigo);
	
	
	
	
	@Query(value="select * from turma",nativeQuery=true)
	List<Turma> getTurmas();
	
	/**
	 * edt turma;
	 * @param codigo
	 * @param nome
	 * @param quantidade_alunos
	 * @return
	 */
	@Modifying
	@Transactional
	@Query(value="update turma set nome=:nome,quantidade_alunos=:quantidade_alunos "
			+ "where codigo=:codigo",nativeQuery=true)
	Integer editTurma(@Param("codigo") String codigo, @Param("nome") String nome, @Param("quantidade_alunos") Integer quantidade_alunos);
	
	
	
	@Query(value="select * from turma where codigo=:codigo",nativeQuery=true)
	Turma getTurmaByCodigo(@Param("codigo") String codigo);
	
}