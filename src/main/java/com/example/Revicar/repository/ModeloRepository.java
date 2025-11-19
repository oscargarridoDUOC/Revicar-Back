package com.example.Revicar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Revicar.model.Modelo;

public interface ModeloRepository extends JpaRepository<Modelo, Integer> {
    List<Modelo> findByMarcaId(Integer marcaId);

}
