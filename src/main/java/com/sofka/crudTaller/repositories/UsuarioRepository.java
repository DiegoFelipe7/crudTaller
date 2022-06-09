package com.sofka.crudTaller.repositories;

import com.sofka.crudTaller.models.UsuarioModel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UsuarioRepository extends CrudRepository<UsuarioModel,Long> {
    public abstract List<UsuarioModel> findByPrioridad(Integer prioridad);
}
