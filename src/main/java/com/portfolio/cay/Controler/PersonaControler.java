
package com.portfolio.cay.Controler;

import com.portfolio.cay.Dto.dtoPersona;
import com.portfolio.cay.Entity.Persona;
import com.portfolio.cay.Security.Controller.Mensaje;
import com.portfolio.cay.Service.ImpPersonaService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/personas")
@CrossOrigin(origins = {"https://pfolio-acs.web.app","http://localhost:4200"})
public class PersonaControler {
   
    @Autowired
    ImpPersonaService impPersonaService;

    @GetMapping("/lista")
    public ResponseEntity<List<Persona>> list() {
        List<Persona> list = impPersonaService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id") int id) {
// El id buscado no existe
        if (!impPersonaService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe."), HttpStatus.NOT_FOUND);
        }
        Persona persona = impPersonaService.getOne(id).get();
        return new ResponseEntity(persona, HttpStatus.OK);
    }
/*
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoEstudio dtoEst) {
// No puede haber datos en blanco
        if (StringUtils.isBlank(dtoEst.getTituloEs())) {
            return new ResponseEntity(new Mensaje("El Titulo es obligatorio."), HttpStatus.BAD_REQUEST);
        }
// El dato ya existe 
//        if (estudioService.existsByTituloEs(dtoEst.getTituloEs())) {
//            return new ResponseEntity(new Mensaje("El Titulo ya existe."), HttpStatus.BAD_REQUEST);
//        }

        Estudio estudio = new Estudio(
                dtoEst.getInstitucionEs(),
                dtoEst.getTituloEs(),
                dtoEst.getDesdeHastaEs(),
                dtoEst.getUrlLogoEs());

        estudioService.save(estudio);
        return new ResponseEntity(new Mensaje("Estudio agregado."), HttpStatus.OK);
    }
*/
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoPersona dtoPer) {
// El id buscado no existe
        if (!impPersonaService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe."), HttpStatus.BAD_REQUEST);
        }
// No debe existir otro igual
        if (impPersonaService.existsByNombre(dtoPer.getNombre()) && impPersonaService.getByNombre(dtoPer.getNombre()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("El Titulo ya existe."), HttpStatus.BAD_REQUEST);
        }
// No vacio
        if (StringUtils.isAnyBlank(dtoPer.getNombre())) {
            return new ResponseEntity(new Mensaje("El Titulo es obligatorio."), HttpStatus.BAD_REQUEST);
        }

        Persona persona = impPersonaService.getOne(id).get();
        persona.setNombre(dtoPer.getNombre());
        persona.setApellido(dtoPer.getApellido());
        persona.setSubtitulo(dtoPer.getSubtitulo());
        persona.setDescripcion(dtoPer.getDescripcion());
         persona.setImg(dtoPer.getImg());

        impPersonaService.save(persona);
        return new ResponseEntity(new Mensaje("Persona actualizada."), HttpStatus.OK);
    }

    /*
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
// El id buscado no existe
        if (!impPersonaService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe."), HttpStatus.BAD_REQUEST);
        }
        impPersonaService.delete(id);
        return new ResponseEntity(new Mensaje("Estudio borrado."), HttpStatus.OK);

    }
*/
}
