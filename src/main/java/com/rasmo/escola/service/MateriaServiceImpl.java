package com.rasmo.escola.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rasmo.escola.entity.MateriaEntity;
import com.rasmo.escola.repository.MateriaRepository;

@Service
public class MateriaServiceImpl implements MateriaService {

	@Autowired
	private MateriaRepository materiaRepository;
	
	@Override
	public List<MateriaEntity> listarMaterias() {
		try {
			return this.materiaRepository.findAll();
		}catch(Exception e) {
			return new ArrayList<>();
		}
	}
	
	@Override
	public MateriaEntity consultarMateria(Long id) {
		try {
			Optional<MateriaEntity> materiaOptional = this.materiaRepository.findById(id);
			if(materiaOptional.isPresent()) {
				return materiaOptional.get();
			}
		return null;	
		} catch(Exception e) {
			return null;
		}
	}

	@Override
	public Boolean cadastrarMateria(MateriaEntity materia) {
		try {
			this.materiaRepository.save(materia);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	@Override
	public Boolean atualizarMateria(MateriaEntity materia) {
		try {
			Optional<MateriaEntity> materiaOptional = this.materiaRepository.findById(materia.getId());
			if(materiaOptional.isPresent()) {
				MateriaEntity materiaAtualizada= materiaOptional.get();
				materiaAtualizada.setNome(materia.getNome());
				materiaAtualizada.setCodigo(materia.getCodigo());
				materiaAtualizada.setFrequencia(materia.getFrequencia());
				materiaAtualizada.setHoras(materia.getHoras());
				this.materiaRepository.save(materiaAtualizada);
				return true;
			}
			return false;	
		}catch(Exception e) {
			return false; 
		}
	}

	@Override
	public Boolean excluirMateria(Long id) {
		try {
			this.materiaRepository.deleteById(id);
			return true;
		}catch(Exception e) {
			return false;
		}
	}





}
