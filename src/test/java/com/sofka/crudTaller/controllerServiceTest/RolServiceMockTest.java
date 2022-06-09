package com.sofka.crudTaller.controllerServiceTest;
import com.sofka.crudTaller.repositories.RolRepository;
import com.sofka.crudTaller.repositories.UsuarioRepository;
import com.sofka.crudTaller.service.RolService;
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
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@SpringBootTest
public class RolServiceMockTest {
    @MockBean
    RolRepository rolRepository;

    @Autowired
    RolService rolService;

    @Test
    public void testUsuarioMock(){
        when(rolRepository.findAll()).thenReturn(new ArrayList<>());
        assertThat(rolService.listaRol()).isEmpty();
        verify(rolRepository).findAll();
    }
}
