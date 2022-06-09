package com.sofka.crudTaller.service;

import com.sofka.crudTaller.models.RolesModel;
import com.sofka.crudTaller.models.UsuarioModel;
import com.sofka.crudTaller.repositories.RolRepository;
import com.sofka.crudTaller.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class RolService {
    @Autowired
    private RolRepository rolRepository;
    public RolesModel guardarRol(RolesModel rol){
        return rolRepository.save(rol);
    }

    public List<RolesModel> listaRol(){
        return (List<RolesModel>) this.rolRepository.findAll();
    }

    public Optional<RolesModel> obtenerPorId(Long id){
        return this.rolRepository.findById(id);
    }


    public RolesModel actualizarRol(RolesModel rol , Long id){
        rol.setId(id);
        return this.rolRepository.save(rol);
    }


    public boolean eliminarRol(Long id){
        try {
            this.rolRepository.deleteById(id);
            return true;
        }catch (Exception err){
            return false;
        }
    }
}
