package pe.softrami.app.repo;

import io.swagger.models.auth.In;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.softrami.app.models.Libro;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Integer> {

}
