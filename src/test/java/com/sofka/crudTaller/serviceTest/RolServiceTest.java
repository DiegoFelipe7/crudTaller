package com.sofka.crudTaller.serviceTest;


import com.sofka.crudTaller.models.RolesModel;
import com.sofka.crudTaller.models.UsuarioModel;
import com.sofka.crudTaller.repositories.RolRepository;
import com.sofka.crudTaller.repositories.UsuarioRepository;
import com.sofka.crudTaller.service.UsuarioService;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@SpringBootTest
public class RolServiceTest {
    @Autowired
    RolRepository rolRepository;

    @Test
    public void testGuardarRol(){
        UsuarioModel usuarioModel=new UsuarioModel();
        RolesModel rolmodel=new RolesModel(usuarioModel,"Admin");
        RolesModel rolmodelRegistro = rolRepository.save(rolmodel);
        assertNotNull(rolmodelRegistro);
    }

    @Test
    public void testBuscarRolPorId(){
        Long idBuscado=1L;
        Optional<RolesModel> rolesModelResultado=rolRepository.findById(idBuscado);
        assertThat(rolesModelResultado.get().getId()).isEqualTo(idBuscado);
    }

    @Test
    public void testlistaRol(){
        List<RolesModel> rolesModelList=(List<RolesModel>) rolRepository.findAll();
        assertThat(rolesModelList).size().isGreaterThan(0);
    }
}
