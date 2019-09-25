package com.ufpb.dsc.caderneta.points;

import com.ufpb.dsc.caderneta.dtos.AlunoDTO;
import com.ufpb.dsc.caderneta.dtos.AlunosDTOLIST;
import com.ufpb.dsc.caderneta.model.Alunos;
import com.ufpb.dsc.caderneta.repository.AlunosRepository;
import com.ufpb.dsc.caderneta.service.AlunoService;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
	
	
	@PostMapping(value="/add/aluno/", consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AlunoDTO> addAluno(@RequestParam String nome, @RequestParam String cpfResponsavel,
			@RequestParam String cpf , @RequestParam String dataNascimento , @RequestParam String responsavel ){
		
		boolean result = this.alunoService.addAluno(nome, cpfResponsavel, cpf, dataNascimento, responsavel);
		if(result) {
			// DTO RESPONSE STATUS 200 HTTP.STATUS.OK= DTO TA MASSA
			AlunoDTO aluno = new AlunoDTO("Aluno Criado com sucesso");
			return   ResponseEntity.status(HttpServletResponse.SC_ACCEPTED).body(aluno);
		}else {
			// DTO RESPONSE STATUS 403 FORRBIDEN HTTP.STATUS.FORRBIDEN = DTO RETORNA MENSAGEM DE ERROR;
			AlunoDTO aluno = new AlunoDTO("Aluno não foi criado com sucesso!",true,"Já existe um aluno criado com esse CPF .");
			return ResponseEntity.status(HttpServletResponse.SC_FORBIDDEN).body(aluno);
		}
	
	}
	
	
	@PutMapping(value="/edit/aluno/", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AlunoDTO> editAluno(@RequestParam String cpf, @RequestParam String cpfResponsavel,
			@RequestParam String nome , @RequestParam String dataNascimento , @RequestParam String responsavel){	
		boolean result = this.alunoService.checkAlunoByCpf(cpf);
		if(result) {
			System.err.println(this.alunoService.editAluno(cpf, cpfResponsavel, nome, dataNascimento, responsavel));
			
			if(this.alunoService.editAluno(cpf, cpfResponsavel, nome, dataNascimento, responsavel) != 0) {
				// DTO SUCESSO OK 200
				
				AlunoDTO aluno = new AlunoDTO("Aluno editado com sucesso.");
				return ResponseEntity.status(HttpServletResponse.SC_ACCEPTED).body(aluno);
			}else {
				// ERROR ACONTECEU AO EDITAR;
			}
		}else {
			// DTO ERRO 
			
			AlunoDTO aluno = new AlunoDTO("Aluno não existe no sistema",true,"Não existe um aluno com este CPF, "
					+ "logo não é possivel editar.");
			
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(aluno);
		}
		return null;
		
	}
	
	@DeleteMapping(value="/delete/aluno/", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AlunoDTO> removeAluno(@RequestParam String cpf){
		
		
		Alunos aluno = this.alunoService.getAlunoByCpf(cpf);
		if(aluno != null) {
			this.alunoService.removeAluno(aluno);
			AlunoDTO dto = new AlunoDTO("Aluno removido com sucesso.");
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(dto);
		}else {
			AlunoDTO dto = new AlunoDTO("Aluno não foi removido",true,"Não foi possivel encontrar o Aluno com este CPF");
			
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(dto);
		}
		
	}
    
	@GetMapping(value="/get/aluno/", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AlunosDTOLIST> getAlunos(){
	
		if(this.alunoService.getAllAlunos().size() != 0 && this.alunoService.getAllAlunos() != null) {
			AlunosDTOLIST dtoList = new AlunosDTOLIST(this.alunoService.getAllAlunos().size(),this.alunoService.getAllAlunos());
			
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(dtoList);
		}else {
			AlunosDTOLIST dtoList = new AlunosDTOLIST(null,null);
			
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(dtoList);
		}
		
	}
}
