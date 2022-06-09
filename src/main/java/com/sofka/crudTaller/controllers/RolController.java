package com.sofka.crudTaller.controllers;

import com.sofka.crudTaller.models.RolesModel;
import com.sofka.crudTaller.service.RolService;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.jboss.logging.Logger;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rol")
public class RolController {
    @Autowired
    private RolService rolService;

    public static final Logger logger = Logger.getLogger("logger");
    @GetMapping(path = "")
    public List<RolesModel> listaRoles() {
        return this.rolService.listaRol();
    }

    @GetMapping(path = "/{id}")
    public Optional<RolesModel> buscarRol(@PathVariable("id") Long id){
        return this.rolService.obtenerPorId(id);
    }

    @PostMapping(path = "")
    public RolesModel guardarRol(@RequestBody RolesModel roles) {
        return this.rolService.guardarRol(roles);
    }
    @RequestMapping(value = "/{id}",
            produces = "application/json",
            method=RequestMethod.PUT)
    public RolesModel actualizarRol(@RequestBody RolesModel roles , @PathVariable("id") Long id ){
        return this.rolService.actualizarRol(roles,id);
    }

    @DeleteMapping(path = "/{id}")
    public String eliminarRol(@PathVariable("id") Long id) {
        boolean ok = this.rolService.eliminarRol(id);
        if (ok) {
            return "Registro N° "+id + "eliminado correctamente";
        } else {
            return "Ocurrio un error eliminado el registro N° " +id;
        }
    }
}
