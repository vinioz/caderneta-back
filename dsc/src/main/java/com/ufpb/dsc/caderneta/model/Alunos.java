package com.ufpb.dsc.caderneta.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Alunos {
    
	
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    private String nome;

    private String cpf;
    
    private String responsavel;
    
    private String cpfResponsavel;

    private String dataNascimento;
    
    
    @ManyToMany
    @JoinTable(name="alunos_turma", joinColumns= {@JoinColumn(name="aluno_id", referencedColumnName="id")},
	inverseJoinColumns= {@JoinColumn(name="turma_id", referencedColumnName="id")})
    private List<Turma> turmas_aluno;
    
    
    
    
    
    public Alunos() {}
    
    
    public Alunos(String nome,String cpf, String cpfResponsavel, String responsavel,String dataNascimento) {
    	setNome(nome);
    	setCpf(cpf);
    	setCpfResponsavel(cpfResponsavel);
    	setResponsavel(responsavel);
    	setDataNascimento(dataNascimento);
    	
    }
    
    
    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public String getCpfResponsavel() {
        return cpfResponsavel;
    }

    public void setCpfResponsavel(String cpfResponsavel) {
        this.cpfResponsavel = cpfResponsavel;
    }

    @Override
    public String toString() {
        return "Alunos{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", responsavel='" + responsavel + '\'' +
                ", cpfResponsavel='" + cpfResponsavel + '\'' +
                '}';
    }

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
}
