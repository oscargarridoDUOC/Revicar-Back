package com.example.Revicar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Revicar.model.Modelo;
import com.example.Revicar.repository.ModeloRepository;

@Service
public class ModeloService {

    @Autowired
    private ModeloRepository modeloRepository;

    public List<Modelo> listar() {
        return modeloRepository.findAll();
    }

    public Modelo obtenerPorId(Integer id) {
        return modeloRepository.findById(id).orElse(null);
    }

    public List<Modelo> listarPorMarca(Integer marcaId) {
        return modeloRepository.findByMarcaId(marcaId);
    }

    public Modelo guardar(Modelo modelo) {
        return modeloRepository.save(modelo);
    }
    public Modelo actualizar(Integer id, Modelo modeloNuevo) {
        Modelo existente = modeloRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Modelo no encontrado"));

        existente.setNombre(modeloNuevo.getNombre());
        existente.setMarca(modeloNuevo.getMarca());
        return modeloRepository.save(existente);
    }

    public void eliminar(Integer id) {
        modeloRepository.deleteById(id);
    }
}

