package com.portfolio.cay.Controler;

import com.portfolio.cay.Dto.dtoEstudio;
import com.portfolio.cay.Entity.Estudio;
import com.portfolio.cay.Security.Controller.Mensaje;
import com.portfolio.cay.Service.ImpEstudioService;
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
@RequestMapping("/est")
@CrossOrigin(origins = "http://localhost:4200")
public class EstudioControler {

    @Autowired
    ImpEstudioService estudioService;

    @GetMapping("/lista")
    public ResponseEntity<List<Estudio>> list() {
        List<Estudio> list = estudioService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Estudio> getById(@PathVariable("id") Long id) {
// El id buscado no existe
        if (!estudioService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe."), HttpStatus.NOT_FOUND);
        }
        Estudio estudio = estudioService.getOne(id).get();
        return new ResponseEntity(estudio, HttpStatus.OK);
    }

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

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody dtoEstudio dtoEst) {
// El id buscado no existe
        if (!estudioService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe."), HttpStatus.BAD_REQUEST);
        }
// No debe existir otro igual
        if (estudioService.existsByTituloEs(dtoEst.getTituloEs()) && estudioService.getByTituloEs(dtoEst.getTituloEs()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("El Titulo ya existe."), HttpStatus.BAD_REQUEST);
        }
// No vacio
        if (StringUtils.isAnyBlank(dtoEst.getTituloEs())) {
            return new ResponseEntity(new Mensaje("El Titulo es obligatorio."), HttpStatus.BAD_REQUEST);
        }

        Estudio estudio = estudioService.getOne(id).get();
        estudio.setInstitucionEs(dtoEst.getInstitucionEs());
        estudio.setTituloEs(dtoEst.getTituloEs());
        estudio.setDesdeHastaEs(dtoEst.getDesdeHastaEs());
        estudio.setUrlLogoEs(dtoEst.getUrlLogoEs());

        estudioService.save(estudio);
        return new ResponseEntity(new Mensaje("Estudio actualizado."), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
// El id buscado no existe
        if (!estudioService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe."), HttpStatus.BAD_REQUEST);
        }
        estudioService.delete(id);
        return new ResponseEntity(new Mensaje("Estudio borrado."), HttpStatus.OK);

    }
}
