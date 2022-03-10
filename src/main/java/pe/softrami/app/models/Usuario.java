package pe.softrami.app.models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idusuario")
    private Integer id;

    @NotBlank
    private String nombres;

    @NotBlank
    private String apellidos;


    private String nombreCompleto;

    @Email
    @NotBlank
    private String email;


    private String password;

    private  Rol rol;


    @Column(name = "fecha_registro")
    private LocalDateTime fechaRegistro;

    public enum Rol{
        ADMIN,
        LECTOR
    }

    @PrePersist
    private void prePersist(){
        fechaRegistro = LocalDateTime.now();
        nombreCompleto = nombres+ " "+ apellidos;

    }

    @PreUpdate
    private  void preUpdate(){
        nombreCompleto = nombres+" "+apellidos;
    }


}
