package com.sofka.crudTaller.service;

import com.sofka.crudTaller.models.UsuarioModel;
import com.sofka.crudTaller.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioModel guardarUsuarios(UsuarioModel usuario){
        return usuarioRepository.save(usuario);
    }

    public List<UsuarioModel> listadoUsuarios(){
        return (List<UsuarioModel>) usuarioRepository.findAll();
    }

    public UsuarioModel actualizarUsuario(UsuarioModel usuario){
        return usuarioRepository.save(usuario);
    }

    public Optional<UsuarioModel> obtenerPorId(Long id){
        return usuarioRepository.findById(id);
    }
    public List<UsuarioModel>  obtenerPorPrioridad(Integer prioridad) {
        return usuarioRepository.findByPrioridad(prioridad);
    }

    public UsuarioModel actualizarUsuario(UsuarioModel usuarioModel , Long id){
        usuarioModel.setId(id);
        return usuarioRepository.save(usuarioModel);
    }


    public boolean eliminarUsuario(Long id){
        try {
            usuarioRepository.deleteById(id);
            return true;
        }catch (Exception err){
            return false;
        }
    }
}
