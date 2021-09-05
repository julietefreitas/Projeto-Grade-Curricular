package com.rasmo.escola.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rasmo.escola.entity.MateriaEntity;

@Repository
public interface MateriaRepository extends JpaRepository<MateriaEntity, Long> {

}
