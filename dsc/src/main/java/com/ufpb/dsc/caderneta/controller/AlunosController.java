package com.ufpb.dsc.caderneta.controller;

import com.ufpb.dsc.caderneta.model.Alunos;
import com.ufpb.dsc.caderneta.repository.AlunosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/alunosComponent")
public class AlunosController {

    @Autowired
    private AlunosRepository alunosRepository;

    @PostMapping
    @ResponseBody
    public Alunos adicionarAlunos(@RequestBody Alunos alunos){
        return alunosRepository.save(alunos);
    }
    
    
    
    
}
