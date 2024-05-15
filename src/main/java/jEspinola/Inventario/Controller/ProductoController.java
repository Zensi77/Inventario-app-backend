package jEspinola.Inventario.Controller;

import jEspinola.Inventario.Model.Producto;
import jEspinola.Inventario.Repository.FabricanteRepository;
import jEspinola.Inventario.Service.ProductoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    @GetMapping("/productos/{idProducto}") // Se indica que este método se ejecutará cuando se haga una petición GET a la URL base
    public Producto buscarProductoId(@PathVariable int idProducto) { // Se indica que se recibirá un parámetro en la URL
        logger.info("Buscando producto con id: " + idProducto);
        Producto producto = this.productoService.buscarProductoId(idProducto); // Se obtiene el producto por su id
        logger.info(producto.toString()); // Se muestra el producto en la consola
        return producto;
    }

    @PostMapping("/productos") // Se indica que este método se ejecutará cuando se haga una petición POST a la URL base
    public void registrarProducto(@RequestBody Producto producto) { // Se indica que se recibirá un objeto producto en formato JSON
        logger.info("Registrando producto");
        logger.info(producto.toString()); // Se muestra el producto en la consola
        this.productoService.registrarProducto(producto); // Se guarda el producto
    }

    @DeleteMapping("/productos/{idProducto}") // Se indica que este método se ejecutará cuando se haga una petición DELETE a la URL base
    public ResponseEntity<Map> eliminarProducto(@PathVariable int idProducto) { // Se indica que se recibirá un parámetro en la URL
        //! Falta eliminar la el producto de la tabla almacen
        logger.info("Eliminando producto con id: " + idProducto);
        this.productoService.eliminarProducto(idProducto); // Se elimina el producto
        Map<String, String> response = Map.of("mensaje", "Producto eliminado con éxito"); // Se crea un mensaje de respuesta
        return ResponseEntity.ok().body(response); // Se retorna el mensaje de respuesta
    }

    @PutMapping("/productos/{idProducto}") // Se indica que este método se ejecutará cuando se haga una petición PUT a la URL base
    public ResponseEntity<Producto> actualizarProducto(@PathVariable int idProducto, @RequestBody Producto producto) { // Se indica que se recibirá un parámetro en la URL y un objeto producto en formato JSON
        logger.info("Actualizando producto con id: " + idProducto);
        logger.info(producto.toString()); // Se muestra el producto en la consola
        this.productoService.registrarProducto(producto); // Se guarda el producto
        return ResponseEntity.ok(producto); // Se retorna el producto actualizado
    }
}
