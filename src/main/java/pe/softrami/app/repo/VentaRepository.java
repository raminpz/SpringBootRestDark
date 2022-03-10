package pe.softrami.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.softrami.app.models.Libro;
import pe.softrami.app.models.Venta;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Integer> {


}
