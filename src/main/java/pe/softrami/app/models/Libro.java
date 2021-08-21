package pe.softrami.app.models;


import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idlibro")
    private Integer id;

    private String titulo;
    private Float precio;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

//quede minuto 2:04
}
