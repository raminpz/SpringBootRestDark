package pe.softrami.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.softrami.app.models.Libro;
import pe.softrami.app.models.Usuario;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    //Recuperar un usuario por su email.
    Optional<Usuario> findByEmail(String email);

    //Saber si existe un usuario por su email
    boolean existsByEmail(String email);

}
