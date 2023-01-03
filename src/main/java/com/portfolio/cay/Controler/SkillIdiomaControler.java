package com.portfolio.cay.Controler;

import com.portfolio.cay.Dto.dtoSkillIdioma;
import com.portfolio.cay.Entity.SkillIdioma;
import com.portfolio.cay.Security.Controller.Mensaje;
import com.portfolio.cay.Service.ImpSkillIdiomaService;
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
@RequestMapping("/ski")
@CrossOrigin(origins = {"https://pfolio-acs.web.app","http://localhost:4200"})
public class SkillIdiomaControler {

    @Autowired
    ImpSkillIdiomaService skillIdiomaService;

    @GetMapping("/lista")
    public ResponseEntity<List<SkillIdioma>> list() {
        List<SkillIdioma> list = skillIdiomaService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<SkillIdioma> getById(@PathVariable("id") Long id) {
// El id buscado no existe
        if (!skillIdiomaService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe."), HttpStatus.NOT_FOUND);
        }
        SkillIdioma skillIdioma = skillIdiomaService.getOne(id).get();
        return new ResponseEntity(skillIdioma, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoSkillIdioma dtoSkD) {
// No puede haber datos en blanco
        if (StringUtils.isBlank(dtoSkD.getNombre())) {
            return new ResponseEntity(new Mensaje("El Nombre es obligatorio."), HttpStatus.BAD_REQUEST);
        }
// El dato ya existe 
        if (skillIdiomaService.existsByNombre(dtoSkD.getNombre())) {
            return new ResponseEntity(new Mensaje("El Nombre ya existe."), HttpStatus.BAD_REQUEST);
        }

        SkillIdioma skillIdioma = new SkillIdioma(
                dtoSkD.getNombre(),
                dtoSkD.getPorcentaje(),
                dtoSkD.getColor());
        
        skillIdiomaService.save(skillIdioma);
        return new ResponseEntity(new Mensaje("SkillIdioma agregada."), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody dtoSkillIdioma dtoSkD) {
// El id buscado no existe
        if (!skillIdiomaService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe."), HttpStatus.BAD_REQUEST);
        }
// No debe existir otro igual
        if (skillIdiomaService.existsByNombre(dtoSkD.getNombre()) && skillIdiomaService.getByNombre(dtoSkD.getNombre()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("El Nombre ya existe."), HttpStatus.BAD_REQUEST);
        }
// No vacio
        if (StringUtils.isAnyBlank(dtoSkD.getNombre())) {
            return new ResponseEntity(new Mensaje("El Nombre es obligatorio."), HttpStatus.BAD_REQUEST);
        }

        SkillIdioma skillIdioma = skillIdiomaService.getOne(id).get();
        skillIdioma.setNombre(dtoSkD.getNombre());
        skillIdioma.setPorcentaje(dtoSkD.getPorcentaje());
        skillIdioma.setColor(dtoSkD.getColor());
       
        skillIdiomaService.save(skillIdioma);
        return new ResponseEntity(new Mensaje("SkillIdioma actualizada."), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
// El id buscado no existe
        if (!skillIdiomaService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe."), HttpStatus.BAD_REQUEST);
        }
        skillIdiomaService.delete(id);
        return new ResponseEntity(new Mensaje("SkillIdioma borrada."), HttpStatus.OK);

    }
}
