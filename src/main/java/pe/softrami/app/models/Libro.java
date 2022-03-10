package pe.softrami.app.models;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@Entity
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idlibro")
    private Integer id;

    @NotBlank
    private String titulo;

    @NotBlank
    private String slug;


    @NotBlank
    private String descripcion;


    @NotNull
    private Float precio;

    @NotBlank
    private String rutaPortada;

    @NotBlank
    private String rutaArchivo;


    private LocalDateTime fechaCreacion;

    @Transient // Esta anotacion indica que este campo, no se va persistir, no existe en la bd
    private String urlPortada;

    @Transient // Esta anotacion indica que este campo, no se va persistir, no existe en la bd
    private String urlArchivo;

    @PrePersist
    private void asignarFechaCreacion(){
        fechaCreacion = LocalDateTime.now();
    }

}
