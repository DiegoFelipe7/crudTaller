package com.sofka.crudTaller.controllers;

import com.sofka.crudTaller.models.UsuarioModel;
import com.sofka.crudTaller.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping(path = "")
    public List<UsuarioModel> listadoUsuarios() {
        return this.usuarioService.listadoUsuarios();
    }

    @GetMapping(path = "/{id}")
    public Optional<UsuarioModel> buscarUsuario(@PathVariable("id") Long id){
        return this.usuarioService.obtenerPorId(id);
    }
    @GetMapping("/query")
    public List<UsuarioModel> obtenerUsuarioPorPrioridad(@RequestParam("prioridad") Integer prioridad) {
        return this.usuarioService.obtenerPorPrioridad(prioridad);
    }

    @PostMapping(path = "")
    public UsuarioModel guardarUsuario(@RequestBody UsuarioModel usuarioModel) {
        return this.usuarioService.guardarUsuarios(usuarioModel);
    }
    @PutMapping(path = "/{id}")
    public UsuarioModel actualizarUsuario(@RequestBody UsuarioModel usuarioModel , @PathVariable("id") Long id ){
        return this.usuarioService.actualizarUsuario(usuarioModel,id);
    }

    @DeleteMapping(path = "/{id}")
    public String eliminarUsuarios(@PathVariable("id") Long id) {
        boolean ok = this.usuarioService.eliminarUsuario(id);
        if (ok) {
            return "Registro N° "+id + "eliminado correctamente";
        } else {
            return "Ocurrio un error eliminado el registro N° " +id;
        }
    }
}
