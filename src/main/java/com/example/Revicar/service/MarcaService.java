package com.example.Revicar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Revicar.model.Marca;
import com.example.Revicar.repository.MarcaRepository;

@Service
public class MarcaService {

    @Autowired
    private MarcaRepository marcaRepository;

    public List<Marca> listar() {
        return marcaRepository.findAll();
    }

    public Marca obtenerPorId(Integer id) {
        return marcaRepository.findById(id).orElse(null);
    }

    public Marca guardar(Marca marca) {
        return marcaRepository.save(marca);
    }

    public Marca actualizar(Integer id, Marca marcaNueva) {
        Marca existente = marcaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Marca no encontrada"));

        existente.setNombre(marcaNueva.getNombre());
        return marcaRepository.save(existente);
    }

    public void eliminar(Integer id) {
        marcaRepository.deleteById(id);
    }
}
