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
import com.badas.springboot.model.Disciplina;
import com.badas.springboot.repository.DisciplinaRepository;

@RestController
@RequestMapping("/api/v1/disciplina")
public class DisciplinaController {
	
	@Autowired
	private DisciplinaRepository disciplinaRepository;
	
	@GetMapping
	public List<Disciplina> getAllDisplDisciplinas() {
		return disciplinaRepository.findAll();
	}
	
	@PostMapping
	public Disciplina createDisciplina(@RequestBody Disciplina disciplina) {
		return disciplinaRepository.save(disciplina);
	}
	
	@GetMapping
	public ResponseEntity<Disciplina> getDisciplinaById(@PathVariable Long id) {
		Disciplina disciplina = disciplinaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Disciplina não encontrado" + id));
		return ResponseEntity.ok(disciplina);
	}
	
	@PutMapping 
	public Disciplina updateDisciplina(@PathVariable Long id, @RequestBody Disciplina disciplinaDetails) {
		Disciplina disciplina = disciplinaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Disciplina não encontrado" + id));
		
		disciplina.setName(disciplinaDetails.getName());
		
		return disciplinaRepository.save(disciplina);
	}
	
	@DeleteMapping
	public void deleteDisciplina(@PathVariable Long id) {
		Disciplina disciplina = disciplinaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Disciplina não encontrado" + id));
		
		disciplinaRepository.delete(disciplina);
	}
	

}
