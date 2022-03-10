package pe.softrami.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.softrami.app.models.ItemVenta;
import pe.softrami.app.models.Libro;

@Repository
public interface ItemVentaRepository extends JpaRepository<ItemVenta, Integer> {


}
