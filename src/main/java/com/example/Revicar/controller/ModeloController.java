package com.example.Revicar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Revicar.model.Modelo;
import com.example.Revicar.service.ModeloService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/modelos")
@Tag(name = "Gestión de Modelos de Autos")
@CrossOrigin("*")
public class ModeloController {

    @Autowired
    private ModeloService modeloService;

    @GetMapping
    @Operation(summary = "Obtener todos los modelos")
    public List<Modelo> getAllModelos() {
        return modeloService.listar();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener un modelo por ID")
    public Modelo getModeloById(@PathVariable Integer id) {
        return modeloService.obtenerPorId(id);
    }

    @GetMapping("/marca/{marcaId}")
    @Operation(summary = "Obtener los modelos pertenecientes a una marca")
    public List<Modelo> getModelosByMarca(@PathVariable Integer marcaId) {
        return modeloService.listarPorMarca(marcaId);
    }

    @PostMapping
    @Operation(summary = "Registrar un nuevo modelo")
    public Modelo createModelo(@RequestBody Modelo modelo) {
        return modeloService.guardar(modelo);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar un modelo")
    public Modelo updateModelo(@PathVariable Integer id, @RequestBody Modelo modelo) {
        return modeloService.actualizar(id, modelo);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un modelo")
    public void deleteModelo(@PathVariable Integer id) {
        modeloService.eliminar(id);
    }
}
