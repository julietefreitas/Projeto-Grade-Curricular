package com.rasmo.escola.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.rasmo.escola.dto.MateriaDTO;
import com.rasmo.escola.entity.MateriaEntity;
import com.rasmo.escola.exception.MateriaException;
import com.rasmo.escola.repository.MateriaRepository;

@Service
public class MateriaServiceImpl implements MateriaService {

	@Autowired
	private MateriaRepository materiaRepository;
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	public MateriaServiceImpl(MateriaRepository materiaRepository) {
		this.mapper = new ModelMapper();
		this.materiaRepository = materiaRepository;
	}
	
	@Override
	public List<MateriaEntity> listarMaterias() {
		try {
			return this.materiaRepository.findAll();
		}catch(Exception e) {
			return new ArrayList<>();
		}
	}
	
	@Override
	public MateriaDTO consultarMateria(Long id) {
		try {
			Optional<MateriaEntity> materiaOptional = this.materiaRepository.findById(id);
			if(materiaOptional.isPresent()) {
				 return mapper.map(materiaOptional.get(),MateriaDTO.class);

			}
			throw new MateriaException("Matéria não Encontrada!", HttpStatus.NOT_FOUND);	
		} catch(MateriaException e) {
			throw new MateriaException("Erro interno identificado. Contate o suporte!", HttpStatus.INTERNAL_SERVER_ERROR);	
		}
	}

	@Override
	public Boolean cadastrarMateria(MateriaDTO materia) {
		try {
			MateriaEntity materiaEntity = mapper.map(materia,MateriaEntity.class);
			this.materiaRepository.save(materiaEntity);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	@Override
	public Boolean atualizarMateria(MateriaDTO materia) {
		try {
			Optional<MateriaEntity> materiaOptional = this.materiaRepository.findById(materia.getId());
			if(materiaOptional.isPresent()) {
				MateriaEntity entity = mapper.map(materia,MateriaEntity.class);
				this.materiaRepository.save(entity);
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
			this.consultarMateria(id);
			this.materiaRepository.deleteById(id);
			return true;
		}catch(MateriaException e) {
			throw e;
		}catch(Exception e) {
			throw e;
		}
	}





}
