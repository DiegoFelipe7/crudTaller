package com.sofka.crudTaller.models;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "roles")
public class RolesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY , targetEntity = UsuarioModel.class , cascade = CascadeType.REMOVE )
    @JoinColumn(name="id_rol")
    @JsonBackReference
    private UsuarioModel id_rol;
    @Column(name = "rol")
    private String rol;

    public RolesModel(Long id, UsuarioModel id_rol, String rol) {
        this.id = id;
        this.id_rol = id_rol;
        this.rol = rol;
    }

    public RolesModel() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UsuarioModel getId_rol() {
        return id_rol;
    }

    public void setId_rol(UsuarioModel id_rol) {
        this.id_rol = id_rol;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
