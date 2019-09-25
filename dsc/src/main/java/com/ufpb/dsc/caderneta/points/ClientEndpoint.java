package com.ufpb.dsc.caderneta.points;

import com.ufpb.dsc.caderneta.dtos.AlunoDTO;
import com.ufpb.dsc.caderneta.model.Alunos;
import com.ufpb.dsc.caderneta.repository.AlunosRepository;
import com.ufpb.dsc.caderneta.service.AlunoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client")
public class ClientEndpoint {

 
    
	
	private AlunoService alunoService;

	
	
	@Autowired
	public ClientEndpoint(AlunoService alunoService) {
		this.alunoService=alunoService;
	}
	
	
	@PostMapping(value="/add/aluno/", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AlunoDTO> addAluno(@RequestParam String nome, @RequestParam String cpfResponsavel,
			@RequestParam String cpf , @RequestParam String dataNascimento , @RequestParam String responsavel ){
		
		
		if(this.alunoService.addAluno(nome, cpfResponsavel, cpf, dataNascimento, responsavel)) {
			// DTO RESPONSE STATUS 200 HTTP.STATUS.OK= DTO TA MASSA
		}else {
			// DTO RESPONSE STATUS 403 FORRBIDEN HTTP.STATUS.FORRBIDEN = DTO RETORNA MENSAGEM DE ERROR;
		}
	
		return null;
	}
	
	
	@PutMapping(value="/edit/aluno", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AlunoDTO> editAluno(@RequestParam String cpf, @RequestParam String cpfResponsavel,
			@RequestParam String nome , @RequestParam String dataNascimento , @RequestParam String responsavel){
		
		
		boolean result = this.alunoService.checkAlunoByCpf(cpf);
		if(result) {
			if(this.alunoService.editAluno(cpf, cpfResponsavel, nome, dataNascimento, responsavel)) {
				// DTO SUCESSO OK 200
			}else {
				// ERROR ACONTECEU AO EDITAR;
			}
		}else {
			// DTO ERRO 
		}
		return null;
		
	}
	
	@DeleteMapping(value="/delete/aluno", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AlunoDTO> removeAluno(@RequestParam String cpf){
		
		
		return null;
		
	}
    
}
