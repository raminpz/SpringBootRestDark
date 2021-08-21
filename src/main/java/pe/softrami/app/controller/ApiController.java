package pe.softrami.app.controller;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.softrami.app.models.Libro;
import pe.softrami.app.repo.LibroRepository;

import java.util.List;


@RestController
@RequestMapping
public class ApiController {


    @Autowired
    private LibroRepository libroRepository;


    @GetMapping("/libros")
    List<Libro> getLibros(){
        return libroRepository.findAll();
    }

    @PostMapping("/libros")
    Libro crearLibro(@RequestBody Libro libro){
       return libroRepository.save(libro);
    }



}
