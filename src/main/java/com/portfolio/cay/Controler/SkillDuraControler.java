
package com.portfolio.cay.Controler;

import com.portfolio.cay.Dto.dtoSkillDura;
import com.portfolio.cay.Entity.SkillDura;
import com.portfolio.cay.Security.Controller.Mensaje;
import com.portfolio.cay.Service.ImpSkillDuraService;
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
@RequestMapping("/skd")
@CrossOrigin(origins = {"https://pfolio-acs.web.app","http://localhost:4200"})
public class SkillDuraControler {

    @Autowired
    ImpSkillDuraService skillDuraService;

    @GetMapping("/lista")
    public ResponseEntity<List<SkillDura>> list() {
        List<SkillDura> list = skillDuraService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<SkillDura> getById(@PathVariable("id") Long id) {
// El id buscado no existe
        if (!skillDuraService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe."), HttpStatus.NOT_FOUND);
        }
        SkillDura skillDura = skillDuraService.getOne(id).get();
        return new ResponseEntity(skillDura, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoSkillDura dtoSkD) {
// No puede haber datos en blanco
        if (StringUtils.isBlank(dtoSkD.getNombre())) {
            return new ResponseEntity(new Mensaje("El Nombre es obligatorio."), HttpStatus.BAD_REQUEST);
        }
// El dato ya existe 
        if (skillDuraService.existsByNombre(dtoSkD.getNombre())) {
            return new ResponseEntity(new Mensaje("El Nombre ya existe."), HttpStatus.BAD_REQUEST);
        }

        SkillDura skillDura = new SkillDura(
                dtoSkD.getNombre(),
                dtoSkD.getPorcentaje(),
                dtoSkD.getColor());
        
        skillDuraService.save(skillDura);
        return new ResponseEntity(new Mensaje("SkillDura agregada."), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody dtoSkillDura dtoSkD) {
// El id buscado no existe
        if (!skillDuraService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe."), HttpStatus.BAD_REQUEST);
        }
// No debe existir otro igual
        if (skillDuraService.existsByNombre(dtoSkD.getNombre()) && skillDuraService.getByNombre(dtoSkD.getNombre()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("El Nombre ya existe."), HttpStatus.BAD_REQUEST);
        }
// No vacio
        if (StringUtils.isAnyBlank(dtoSkD.getNombre())) {
            return new ResponseEntity(new Mensaje("El Nombre es obligatorio."), HttpStatus.BAD_REQUEST);
        }

        SkillDura skillDura = skillDuraService.getOne(id).get();
        skillDura.setNombre(dtoSkD.getNombre());
        skillDura.setPorcentaje(dtoSkD.getPorcentaje());
        skillDura.setColor(dtoSkD.getColor());
       
        skillDuraService.save(skillDura);
        return new ResponseEntity(new Mensaje("SkillDura actualizada."), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
// El id buscado no existe
        if (!skillDuraService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe."), HttpStatus.BAD_REQUEST);
        }
        skillDuraService.delete(id);
        return new ResponseEntity(new Mensaje("SkillDura borrada."), HttpStatus.OK);

    }
}
