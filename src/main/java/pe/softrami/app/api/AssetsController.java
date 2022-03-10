package pe.softrami.app.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pe.softrami.app.service.FileSystemStorageService;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/assets")
public class AssetsController extends BaseController{

    @Autowired //Inyectar las dependencias de FileSystemStorageService
    private FileSystemStorageService fileSystemStorageService;

    //Recuperar un archivo a partir de su nombre
    @GetMapping("/{filename:.+}")
    Resource getResource(@PathVariable String filename){
        return fileSystemStorageService.loadAsResource(filename);
    }

    //Subir un archivo y retornar la ruta relativa y URL donde está ubicado
    @PostMapping("/upload")
    Map<String, String> subirArchivo(@RequestParam("file")MultipartFile multipartFile){
        String rutaArchivo = fileSystemStorageService.store(multipartFile);
        String rutaAbsoluta = buildUriString(rutaArchivo);

        Map<String, String> resultado = new HashMap<>();
        resultado.put("ruta", rutaArchivo);
        resultado.put("url", rutaAbsoluta);

        return resultado;
    }
}
