package com.rasmo.escola.service;

import java.util.List;

import com.rasmo.escola.dto.MateriaDTO;
import com.rasmo.escola.entity.MateriaEntity;

public interface MateriaService {
	
	public List<MateriaEntity> listarMaterias();
	
	public MateriaDTO consultarMateria(final Long id);
	
	public Boolean cadastrarMateria(final MateriaDTO materia);
	
	public Boolean atualizarMateria(final MateriaDTO materia);
	
	public Boolean excluirMateria(final Long id);
}
