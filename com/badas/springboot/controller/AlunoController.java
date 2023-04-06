package com.badas.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.badas.springboot.exception.ResourceNotFoundException;
import com.badas.springboot.model.Aluno;
import com.badas.springboot.repository.AlunoRepository;

@RestController
@RequestMapping("/api/v1/alunos")
public class AlunoController {
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	@GetMapping
	public List<Aluno> getAllAlunos() {
		return alunoRepository.findAll();
	}
	
	@PostMapping
	public Aluno createAluno(@RequestBody Aluno aluno) {
		return alunoRepository.save(aluno);
	}
	
	@GetMapping
	public ResponseEntity<Aluno> getAlunoByIdEntity(@PathVariable Long id) {
		Aluno aluno = alunoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Aluno não encontrado" + id));
		return ResponseEntity.ok(aluno);
	}
	
	@PutMapping
	public Aluno updateAluno(@PathVariable Long id, @RequestBody Aluno alunoDetails) {
		Aluno aluno = alunoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Aluno não encontrado" + id));
		
		aluno.setTurmas(alunoDetails.getTurmas());
		
		return alunoRepository.save(aluno);
	}
	
	@DeleteMapping
	public void deleteAluno(@PathVariable Long id) {
		Aluno aluno = alunoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Aluno não encontrado" + id));
		
		alunoRepository.delete(aluno);
	}

}