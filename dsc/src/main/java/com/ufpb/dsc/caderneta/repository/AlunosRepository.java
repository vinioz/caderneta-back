package com.ufpb.dsc.caderneta.repository;

import com.ufpb.dsc.caderneta.model.Alunos;

import java.util.List;

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
	@Modifying
	@Transactional
	@Query(value="insert into alunos (cpf,cpf_responsavel,nome,responsavel,data_nascimento) values ("
			+ ":cpf,:cpf_responsavel,:nome,:responsavel,:data_nascimento)",nativeQuery=true)
	void addAluno(@Param("cpf") String cpf, @Param("cpf_responsavel") String cpf_responsavel,
			@Param("nome") String nome , @Param("data_nascimento") String data_nascimento,
			@Param("responsavel") String responsavel);
	
	
	
	
	@Query(value="select * from alunos",nativeQuery=true)
	List<Alunos> getAllAlunos();
	
	@Query(value="select count(*) from alunos",nativeQuery=true)
	Integer getQuantity();
	
	
	/**
	 * 
	 * @param cpf
	 * @return entity state dataset object aluno
	 */
	@Query(value="select * from alunos where cpf=:cpf",nativeQuery=true)
	Alunos checkIfAlunoExist(@Param("cpf") String cpf);
	
	
	@Query(value="select * from alunos",nativeQuery=true)
	List<Alunos> getAlunos();
	
	@Query(value="select * from alunos where cpf=:cpf",nativeQuery=true)
	Alunos getAlunosByCpf(@Param("cpf") String cpf);
	
	
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
	@Query(value = "update alunos set nome=:nome,cpf_responsavel=:cpf_responsavel,data_nascimento=:data_nascimento,"
			+ "responsavel=:responsavel where cpf=:cpf",nativeQuery=true)
	Integer editAluno(@Param("nome") String nome , @Param("cpf_responsavel") String cpf_responsavel, @Param("data_nascimento") String data_nascimento,
			@Param("responsavel") String responsavel , @Param("cpf") String cpf);
}
