package com.rasmo.escola.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rasmo.escola.dto.MateriaDTO;
import com.rasmo.escola.entity.MateriaEntity;
import com.rasmo.escola.service.MateriaServiceImpl;

@RestController
@RequestMapping("/materia")
public class MateriaController {
	
	
	@Autowired
	private MateriaServiceImpl materiaService;
	
	@GetMapping
	public ResponseEntity<List<MateriaEntity>> listarMaterias() {
		return ResponseEntity.status(HttpStatus.OK).body(this.materiaService.listarMaterias());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<MateriaDTO> consultarMaterias(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(this.materiaService.consultarMateria(id));
	}
	
	@PostMapping
	public ResponseEntity<Boolean> cadastrarMateria(@Valid @RequestBody MateriaDTO materia ){
		return ResponseEntity.status(HttpStatus.CREATED).body(this.materiaService.cadastrarMateria(materia));
	}
	
	@DeleteMapping
	public ResponseEntity<Boolean> excluirMateria(@RequestParam Long id){
		return ResponseEntity.status(HttpStatus.OK).body(this.materiaService.excluirMateria(id));
	}
	
	@PutMapping
	public ResponseEntity<Boolean> atualizarMateria(@Valid @RequestBody MateriaDTO materia){
		return ResponseEntity.status(HttpStatus.OK).body(this.materiaService.atualizarMateria(materia));
	}
	


}
