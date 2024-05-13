package jEspinola.Inventario.Controller;

import jEspinola.Inventario.Model.Producto;
import jEspinola.Inventario.Repository.FabricanteRepository;
import jEspinola.Inventario.Service.ProductoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Se indica que esta clase es un controlador REST de Spring
@RequestMapping("/inventario-app") // Se indica la URL base para acceder a los métodos de este controlador
@CrossOrigin(origins = "localhost:4200") // Se indica que se aceptan peticiones del puerto 4200 (Angular)
public class ProductoController {
    private static final Logger logger = LoggerFactory.getLogger(ProductoController.class); // Se crea un logger para mostrar mensajes en la consola

    @Autowired // Se inyecta la dependencia de ProductoService
    private ProductoService productoService;
    @Autowired
    private FabricanteRepository fabricanteRepository;

    //http://localhost:8080/inventario-app/Productos
    @GetMapping("/productos") // Se indica que este método se ejecutará cuando se haga una petición GET a la URL base
    public List<Producto> listarProductos() {
        List<Producto> productos = this.productoService.listarProductos(); // Se obtienen todos los productos
        logger.info("Listando productos");
        productos.forEach(producto -> logger.info(producto.toString())); // Se muestra cada producto en la consola
        return productos;
    }

    @PostMapping("/productos") // Se indica que este método se ejecutará cuando se haga una petición POST a la URL base
    public Producto registrarProducto(@RequestBody Producto producto) { // Se recibe un producto en formato JSON
        logger.info("Registrando producto");
        logger.info(producto.toString()); // Se muestra el producto en la consola
        // De esta forma se puede obtener el fabricante por su id y asignarlo al producto
        // Fabricante fabricante = fabricanteRepository.findById(producto.getFabricante()).orElse(null); // Se obtiene el fabricante por su id
        // producto.setFabricante(fabricante); // Se asigna el fabricante al producto
        return this.productoService.registrarProducto(producto); // Se guarda el producto
    }
}
