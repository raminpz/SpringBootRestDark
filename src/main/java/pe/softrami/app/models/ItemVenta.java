package pe.softrami.app.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class ItemVenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iditem_venta")
    private Integer id;

    private float precio;

    @Column(name = "num_desc_disp")
    private Integer numeroDescargasDisponibles;

    @ManyToOne
    @JoinColumn(name = "idlibro", referencedColumnName = "idlibro")
    private Libro libro;

    @ManyToOne
    @JoinColumn(name = "idventa", referencedColumnName = "idventa")
    private Venta venta;

}
