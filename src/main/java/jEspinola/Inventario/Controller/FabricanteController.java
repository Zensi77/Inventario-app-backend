package jEspinola.Inventario.Controller;

import jEspinola.Inventario.Model.Fabricante;
import jEspinola.Inventario.Service.FabricanteService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import java.util.List;

@RestController // Se indica que esta clase es un controlador REST de Spring
@RequestMapping("/inventario-app") // Se indica la URL base para acceder a los métodos de este controlador
@CrossOrigin(origins = "localhost:4200") // Se indica que se aceptan peticiones del puerto 4200 (Angular)
public class FabricanteController {
    private static final Logger logger = LoggerFactory.getLogger(ProductoController.class); // Se crea un logger para mostrar mensajes en la consola

    @Autowired
        private FabricanteService fabricanteService; // Se inyecta la dependencia de FabricanteService

        @GetMapping("/fabricantes")
        public List<Fabricante> listarFabricantes() {
            List<Fabricante> fabricantes = this.fabricanteService.listarFabricantes(); // Se obtienen todos los fabricantes
            logger.info("Listando fabricantes");
            return fabricantes;
        }

        @PostMapping("/fabricantes")
    public void registrarFabricante(@RequestBody Fabricante fabricante) { // Se indica que se recibirá un objeto Fabricante en formato JSON
        logger.info("Registrando fabricante");
        logger.info(fabricante.toString()); // Se muestra el fabricante en la consola
        this.fabricanteService.registrarFabricante(fabricante); // Se guarda el fabricante
    }

}
