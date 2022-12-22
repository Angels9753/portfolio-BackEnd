
package com.portfolio.cay.Controler;

import com.portfolio.cay.Dto.dtoSkillBlanda;
import com.portfolio.cay.Entity.SkillBlanda;
import com.portfolio.cay.Security.Controller.Mensaje;
import com.portfolio.cay.Service.ImpSkillBlandaService;
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
@RequestMapping("/skb")
@CrossOrigin(origins = "http://localhost:4200")
public class SkillBlandaControler {

    @Autowired
    ImpSkillBlandaService skillBlandaService;

    @GetMapping("/lista")
    public ResponseEntity<List<SkillBlanda>> list() {
        List<SkillBlanda> list = skillBlandaService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<SkillBlanda> getById(@PathVariable("id") Long id) {
// El id buscado no existe
        if (!skillBlandaService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe."), HttpStatus.NOT_FOUND);
        }
        SkillBlanda skillBlanda = skillBlandaService.getOne(id).get();
        return new ResponseEntity(skillBlanda, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoSkillBlanda dtoSkB) {
// No puede haber datos en blanco
        if (StringUtils.isBlank(dtoSkB.getNombre())) {
            return new ResponseEntity(new Mensaje("El Nombre es obligatorio."), HttpStatus.BAD_REQUEST);
        }
// El dato ya existe 
        if (skillBlandaService.existsByNombre(dtoSkB.getNombre())) {
            return new ResponseEntity(new Mensaje("El Nombre ya existe."), HttpStatus.BAD_REQUEST);
        }

        SkillBlanda skillBlanda = new SkillBlanda(
                dtoSkB.getNombre(),
                dtoSkB.getPorcentaje(),
                dtoSkB.getColor());
        
        skillBlandaService.save(skillBlanda);
        return new ResponseEntity(new Mensaje("SkillBlanda agregada."), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody dtoSkillBlanda dtoSkB) {
// El id buscado no existe
        if (!skillBlandaService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe."), HttpStatus.BAD_REQUEST);
        }
// No debe existir otro igual
        if (skillBlandaService.existsByNombre(dtoSkB.getNombre()) && skillBlandaService.getByNombre(dtoSkB.getNombre()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("El Nombre ya existe."), HttpStatus.BAD_REQUEST);
        }
// No vacio
        if (StringUtils.isAnyBlank(dtoSkB.getNombre())) {
            return new ResponseEntity(new Mensaje("El Nombre es obligatorio."), HttpStatus.BAD_REQUEST);
        }

        SkillBlanda skillBlanda = skillBlandaService.getOne(id).get();
        skillBlanda.setNombre(dtoSkB.getNombre());
        skillBlanda.setPorcentaje(dtoSkB.getPorcentaje());
        skillBlanda.setColor(dtoSkB.getColor());
       
        skillBlandaService.save(skillBlanda);
        return new ResponseEntity(new Mensaje("SkillBlanda actualizada."), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
// El id buscado no existe
        if (!skillBlandaService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe."), HttpStatus.BAD_REQUEST);
        }
        skillBlandaService.delete(id);
        return new ResponseEntity(new Mensaje("SkillBlanda borrada."), HttpStatus.OK);

    }
}
