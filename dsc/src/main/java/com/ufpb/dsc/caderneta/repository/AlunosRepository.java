package com.ufpb.dsc.caderneta.repository;

import com.ufpb.dsc.caderneta.model.Alunos;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * 
 * 
 *
 */
public interface AlunosRepository extends JpaRepository<Alunos, Integer> {
	
	 // cpf attr é identificador unico.

	
	/**
	 * Insert on aluno dataset;
	 * @param cpf
	 * @param cpf_responsavel
	 * @param nome
	 * @param data_nascimento
	 * @return
	 */
	@Query(value="insert into alunos (cpf,cpf_responsavel,nome,responsavel,data_nascimento) values ("
			+ ":cpf,:cpf_responsavel,:nome,:responsavel,:data_nascimento)",nativeQuery=true)
	void addAluno(@Param("cpf") String cpf, @Param("cpf_responsavel") String cpf_responsavel,
			@Param("nome") String nome , @Param("data_nascimento") String data_nascimento,
			@Param("responsavel") String responsavel);
	
	
	/**
	 * 
	 * @param cpf
	 * @return entity state dataset object aluno
	 */
	@Query(value="select * from alunos where cpf=:cpf",nativeQuery=true)
	Alunos checkIfAlunoExist(@Param("cpf") String cpf);
	
	
	/**
	 * 
	 * @param nome
	 * @param cpf_responsavel
	 * @param data_nascimento
	 * @param responsavel
	 * @param cpf
	 */
	@Modifying
	@Transactional
	@Query("update alunos set nome=:nome,cpf_responsavel=:cpf_responsavel,data_nascimento=:data_nascimento,"
			+ "responsavel=:responsavel where cpf=:cpf")
	boolean editAluno(@Param("nome") String nome , @Param("cpf_responsavel") String cpf_responsavel, @Param("data_nascimento") String data_nascimento,
			@Param("responsavel") String responsavel , @Param("cpf") String cpf);
}
