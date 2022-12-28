package com.portfolio.cay.Controler;

import com.portfolio.cay.Dto.dtoProyecto;
import com.portfolio.cay.Entity.Proyecto;
import com.portfolio.cay.Security.Controller.Mensaje;
import com.portfolio.cay.Service.ImpProyectoService;
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
@RequestMapping("/pro")
@CrossOrigin(origins = "http://localhost:4200")
public class ProyectoControler {

    @Autowired
    ImpProyectoService proyectoService;

    @GetMapping("/lista")
    public ResponseEntity<List<Proyecto>> list() {
        List<Proyecto> list = proyectoService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyecto> getById(@PathVariable("id") Long id) {
// El id buscado no existe
        if (!proyectoService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe."), HttpStatus.NOT_FOUND);
        }
        Proyecto proyecto = proyectoService.getOne(id).get();
        return new ResponseEntity(proyecto, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoProyecto dtoPro) {
// No puede haber datos en blanco
        if (StringUtils.isBlank(dtoPro.getInstitucionPr())) {
            return new ResponseEntity(new Mensaje("El Institucion es obligatoria."), HttpStatus.BAD_REQUEST);
        }
// El dato ya existe 
//        if (proyectoService.existsByInstitucionPr(dtoPro.getInstitucionPr())) {
//            return new ResponseEntity(new Mensaje("El Institucion ya existe."), HttpStatus.BAD_REQUEST);
//        }

        Proyecto proyecto = new Proyecto(
                dtoPro.getInstitucionPr(),
                dtoPro.getSubtituloPr(),
                dtoPro.getDescripcionPr(),
                dtoPro.getWebPr(),
                dtoPro.getUrlLogoPr());

        proyectoService.save(proyecto);
        return new ResponseEntity(new Mensaje("Proyecto agregado."), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody dtoProyecto dtoPro) {
// El id buscado no existe
        if (!proyectoService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe."), HttpStatus.BAD_REQUEST);
        }
// No debe existir otro igual
        if (proyectoService.existsByInstitucionPr(dtoPro.getInstitucionPr()) && proyectoService.getByInstitucionPr(dtoPro.getInstitucionPr()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("El Institucion ya existe."), HttpStatus.BAD_REQUEST);
        }
// No vacio
        if (StringUtils.isAnyBlank(dtoPro.getInstitucionPr())) {
            return new ResponseEntity(new Mensaje("El Institucion es obligatoria."), HttpStatus.BAD_REQUEST);
        }

        Proyecto proyecto = proyectoService.getOne(id).get();
        proyecto.setInstitucionPr(dtoPro.getInstitucionPr());
        proyecto.setSubtituloPr(dtoPro.getSubtituloPr());
        proyecto.setDescripcionPr(dtoPro.getDescripcionPr());
        proyecto.setWebPr(dtoPro.getWebPr());
        proyecto.setUrlLogoPr(dtoPro.getUrlLogoPr());

        proyectoService.save(proyecto);
        return new ResponseEntity(new Mensaje("Proyecto actualizado."), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
// El id buscado no existe
        if (!proyectoService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe."), HttpStatus.BAD_REQUEST);
        }
        proyectoService.delete(id);
        return new ResponseEntity(new Mensaje("Proyecto borrado."), HttpStatus.OK);

    }
}
