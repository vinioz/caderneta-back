package com.ufpb.dsc.caderneta.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ufpb.dsc.caderneta.model.Curso;

public interface CursoRepository extends JpaRepository<Curso, Integer> {
	/**
	 * 
	 * @param codigo
	 * @param creat_at
	 * @param quantidade
	 * @param professor_id
	 */
	@Modifying
	@Transactional
	@Query(value="insert into curso (codigo,creat_at,nome,quantidade_alunos) values (:codigo,:creat_at,:nome,:quantidade_alunos)",nativeQuery=true)
	void addCurso(@Param("codigo") String codigo , @Param("creat_at") String creat_at, @Param("quantidade_alunos") Integer quantidade,
			@Param("nome") String nome);
	/**
	 * 
	 * @param codigo
	 * @return
	 */
	@Query(value="select * from curso where codigo=:codigo",nativeQuery=true)
	Curso checkIfCursoExistByCod(@Param("codigo") String codigo);
	
	
	
	
	@Query(value="select * from turma",nativeQuery=true)
	List<Curso> getCurso();
	
	/**
	 * edt curso;
	 * @param codigo
	 * @param nome
	 * @param quantidade_alunos
	 * @return
	 */
	@Modifying
	@Transactional
	@Query(value="update curso set nome=:nome,quantidade_alunos=:quantidade_alunos "
			+ "where codigo=:codigo",nativeQuery=true)
	Integer editCurso(@Param("codigo") String codigo, @Param("nome") String nome, @Param("quantidade_alunos") Integer quantidade_alunos);
	
	
	
	@Query(value="select * from curso where codigo=:codigo",nativeQuery=true)
	Curso getCursoByCodigo(@Param("codigo") String codigo);
	
}