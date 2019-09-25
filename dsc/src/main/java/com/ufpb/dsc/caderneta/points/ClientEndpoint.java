package com.ufpb.dsc.caderneta.points;

import com.ufpb.dsc.caderneta.dtos.AlunoDTO;
import com.ufpb.dsc.caderneta.dtos.AlunosDTOLIST;
import com.ufpb.dsc.caderneta.dtos.TurmaDTO;
import com.ufpb.dsc.caderneta.dtos.TurmaDTOLIST;
import com.ufpb.dsc.caderneta.model.Alunos;
import com.ufpb.dsc.caderneta.model.Turma;
import com.ufpb.dsc.caderneta.repository.AlunosRepository;
import com.ufpb.dsc.caderneta.service.AlunoService;
import com.ufpb.dsc.caderneta.service.TurmaService;
import com.ufpb.dsc.caderneta.util.MyCalendary;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client")
public class ClientEndpoint {

 
    
	/**
	 * Service Aluno
	 */
	private AlunoService alunoService;
	
	/**
	 * Service Turma
	 */
	private TurmaService turmaService;

	
	
	@Autowired
	public ClientEndpoint(AlunoService alunoService,TurmaService turmaService) {
		this.alunoService=alunoService;
		this.turmaService=turmaService;
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
	
	
	
	
	@PostMapping(value="/add/turma/",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TurmaDTO> addTurma(@RequestParam("codigo") String codigo,
			@RequestParam("quant_alunos") Integer quant,
			@RequestParam("nome") String nome){
		MyCalendary calendary = new MyCalendary();
		String[] result = calendary.getFormatedDataToday(calendary.getDateToday());
		String creat_at = result[0]+"/"+result[1]+"/"+result[2]+"/"+result[3];
		boolean result_insert = this.turmaService.addTurma(codigo, nome, quant, creat_at);
		if(result_insert) {
			TurmaDTO dto = new TurmaDTO("Turma Criada com sucesso!",codigo,false,0);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(dto);
		}else {
			TurmaDTO dto = new TurmaDTO("Não foi possivel criar uma turma!",codigo,true,0);
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(dto);
		}
	
	}
	
	@PutMapping(value="/edit/turma/",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TurmaDTO> edtTurma(@RequestParam("codigo") String codigo,
			@RequestParam("quant_alunos") Integer quant,
			@RequestParam("nome") String nome){
		
		
		Integer result = this.turmaService.edtTurma(codigo, nome, quant);
		
		if(result!=0) {
			TurmaDTO dto = new TurmaDTO("Turma Editada com sucesso!",codigo,false,0);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(dto);
		}else {
			TurmaDTO dto = new TurmaDTO("Turma não foi editada!",codigo,true,0);
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(dto);
		}
	}
	
	@GetMapping(value="/get/turma/",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TurmaDTOLIST> getTurma(){
		List<Turma> turmas = this.turmaService.getTurmas();
		
		if(turmas != null) {
			TurmaDTOLIST dto = new TurmaDTOLIST(turmas.size(),turmas);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(dto);
		}else {
			TurmaDTOLIST dto = new TurmaDTOLIST(null,null);
			
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(dto);
		}
		
	}
	
	@DeleteMapping(value="/delete/turma/",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TurmaDTO> deleteTurma(@RequestParam("codigo") String codigo){
		
		Turma turma = this.turmaService.checkTurmaByCodigo(codigo);
		if(turma != null) {
			this.turmaService.removeTurma(turma);
			
			TurmaDTO dto = new TurmaDTO("Turma deletada com sucesso!",codigo,false,0);
			
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(dto);
		}
		else {
			TurmaDTO dto = new TurmaDTO("Não foi possivel remover a turma",codigo,true,0);
			
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(dto);
		}
	}
	
}




	