package com.rasmo.escola.service;

import java.util.List;


import com.rasmo.escola.entity.MateriaEntity;

public interface MateriaService {
	
	public List<MateriaEntity> listarMaterias();
	
	public MateriaEntity consultarMateria(final Long id);
	
	public Boolean cadastrarMateria(final MateriaEntity materia);
	
	public Boolean atualizarMateria(final MateriaEntity materia);
	
	public Boolean excluirMateria(final Long id);
}
