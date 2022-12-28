/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.cay.Controler;

import com.portfolio.cay.Dto.dtoExperiencia;
import com.portfolio.cay.Entity.Experiencia;
import com.portfolio.cay.Security.Controller.Mensaje;
import com.portfolio.cay.Service.ImpExperienciaService;

import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exp")
@CrossOrigin(origins = "http://localhost:4200")
public class ExperienciaControler {

    @Autowired
    ImpExperienciaService experienciaService;

    @GetMapping("/lista")
    public ResponseEntity<List<Experiencia>> list() {
        List<Experiencia> list = experienciaService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Experiencia> getById(@PathVariable("id") Long id) {
// El id buscado no existe
        if (!experienciaService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe."), HttpStatus.NOT_FOUND);
        }
        Experiencia experiencia = experienciaService.getOne(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoExperiencia dtoExp) {
// No puede haber datos en blanco
        if (StringUtils.isBlank(dtoExp.getCargoEx())) {
            return new ResponseEntity(new Mensaje("El Cargo es obligatorio."), HttpStatus.BAD_REQUEST);
        }
// El dato ya existe 
//        if (experienciaService.existsByCargoEx(dtoExp.getCargoEx())) {
//            return new ResponseEntity(new Mensaje("El Cargo ya existe."), HttpStatus.BAD_REQUEST);
//        }

        Experiencia experiencia = new Experiencia(dtoExp.getInstitucionEx(),
                dtoExp.getCargoEx(),
                dtoExp.getDescripcionEx(),
                dtoExp.getDesdeHastaEx(),
                dtoExp.getIconoEx());
        experienciaService.save(experiencia);
        return new ResponseEntity(new Mensaje("Experiencia agregada."), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody dtoExperiencia dtoExp) {
// El id buscado no existe
        if (!experienciaService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe."), HttpStatus.BAD_REQUEST);
        }
// No debe existir otro igual
        if (experienciaService.existsByCargoEx(dtoExp.getCargoEx()) && experienciaService.getByCargoEx(dtoExp.getCargoEx()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("El Cargo ya existe."), HttpStatus.BAD_REQUEST);
        }
// No vacio
        if (StringUtils.isAnyBlank(dtoExp.getCargoEx())) {
            return new ResponseEntity(new Mensaje("El Cargo es obligatorio."), HttpStatus.BAD_REQUEST);
        }

        Experiencia experiencia = experienciaService.getOne(id).get();
        experiencia.setInstitucionEx(dtoExp.getInstitucionEx());
        experiencia.setCargoEx(dtoExp.getCargoEx());
        experiencia.setDescripcionEx(dtoExp.getDescripcionEx());
        experiencia.setDesdeHastaEx(dtoExp.getDesdeHastaEx());
        experiencia.setIconoEx(dtoExp.getIconoEx());

        experienciaService.save(experiencia);
        return new ResponseEntity(new Mensaje("Experiencia actualizada."), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
// El id buscado no existe
        if (!experienciaService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe."), HttpStatus.BAD_REQUEST);
        }
        experienciaService.delete(id);
        return new ResponseEntity(new Mensaje("Experiencia borrada."), HttpStatus.OK);

    }
}
