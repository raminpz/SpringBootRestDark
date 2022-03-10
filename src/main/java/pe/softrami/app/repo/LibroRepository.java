package pe.softrami.app.repo;

import io.swagger.models.auth.In;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.softrami.app.models.Libro;
import pe.softrami.app.models.Usuario;

import java.util.Optional;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Integer> {

    //Saber si un libro existe por su slug
    boolean existsBySlug(String slug);

    //Recuperar un libro por su slug
    Optional<Usuario> findOneBySlug(String slug);

    //Saber si un libro existe por su slug y que sea diferente a un ID.
    boolean existsBySlugAndIdNot(String slug, Integer idNot);

}
