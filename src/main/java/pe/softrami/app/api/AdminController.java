package pe.softrami.app.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pe.softrami.app.exception.BadRequestException;
import pe.softrami.app.models.Libro;
import pe.softrami.app.repo.LibroRepository;
import pe.softrami.app.service.FileSystemStorageService;

import javax.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/api/admin/libros")
public class AdminController extends BaseController {

    @Autowired
    private LibroRepository libroRepository;

    @Autowired
    private FileSystemStorageService fileSystemStorageService;

    @PostMapping("") //Metodo crear libro
    Libro crearLibro(@RequestBody @Validated Libro libro){
        boolean slugYaExiste = libroRepository.existsBySlug(libro.getSlug());

        if (slugYaExiste){
            throw new BadRequestException("El slug ya fue registrado.");
        }
        return libroRepository.save(libro);
    }

    @GetMapping("") //Metodo listar libro con paginacion
    Page<Libro> getLibros(@PageableDefault(sort = "titulo", size = 5) Pageable pageable){
        Page<Libro> libroPage = libroRepository.findAll(pageable);

        libroPage.forEach(libro -> {
            libro.setUrlArchivo( buildUriString(libro.getRutaArchivo()) );
            libro.setUrlPortada( buildUriString(libro.getRutaPortada()) );
        });

        return libroPage;
    }

    @GetMapping("/{id}") //Metodo para recuperar libro por ID
    Libro getLibro(@PathVariable Integer id){
        Libro libro = libroRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);

        libro.setUrlArchivo( buildUriString(libro.getRutaArchivo()) );
        libro.setUrlPortada( buildUriString(libro.getRutaPortada()) );

        return libro;
    }
// video 4, 2:15 min
}
