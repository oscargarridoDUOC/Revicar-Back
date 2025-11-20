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

import com.example.Revicar.model.Marca;
import com.example.Revicar.service.MarcaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/marcas")
@Tag(name = "Gestión de Marcas de Autos")
@CrossOrigin("*")
public class MarcaController {

    @Autowired
    private MarcaService marcaService;

    @GetMapping
    @Operation(summary = "Obtener todas las marcas registradas")
    public List<Marca> getAllMarcas() {
        return marcaService.listar();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener una marca por su ID")
    public Marca getMarcaById(@PathVariable Integer id) {
        return marcaService.obtenerPorId(id);
    }

    @PostMapping
    @Operation(summary = "Registrar una nueva marca")
    public Marca createMarca(@RequestBody Marca marca) {
        return marcaService.guardar(marca);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar una marca existente")
    public Marca updateMarca(@PathVariable Integer id, @RequestBody Marca marca) {
        return marcaService.actualizar(id, marca);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar una marca")
    public void deleteMarca(@PathVariable Integer id) {
        marcaService.eliminar(id);
    }
}
