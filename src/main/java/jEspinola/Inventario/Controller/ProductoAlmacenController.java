package jEspinola.Inventario.Controller;

import jEspinola.Inventario.Model.Almacen;
import jEspinola.Inventario.Model.Producto;
import jEspinola.Inventario.Model.ProductoAlmacen;
import jEspinola.Inventario.Service.ProductoAlmacenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventario-app")
@CrossOrigin(origins = "localhost:4200")
public class ProductoAlmacenController {
    private static final Logger logger = LoggerFactory.getLogger(ProductoController.class); // Se crea un logger para mostrar mensajes en la consola


    @Autowired
    private ProductoAlmacenService productoAlmacenService;

    @GetMapping("/productos-almacen/{idAlmacen}")
    public List<ProductoAlmacen> listarProductosAlmacen(@PathVariable int idAlmacen) {
        return this.productoAlmacenService.listarProductosAlmacen(idAlmacen);
    }

    @PostMapping("/productos-almacen")
    public ProductoAlmacen agregarProductoAlmacen(@RequestBody ProductoAlmacen productoAlmacen) {
        return this.productoAlmacenService.agregarProductoAlmacen(productoAlmacen);
    }

    @PutMapping("/productos-almacen/{idProducto}/{idAlmacen}/{cantidad}")
    public ResponseEntity<?> actualizarProductoAlmacen(
            @PathVariable int idProducto,
            @PathVariable int idAlmacen,
            @PathVariable int cantidad) {
        logger.info("Actualizando producto almacen con id " + idAlmacen + " e id_producto " + idProducto);
        this.productoAlmacenService.actualizarProductoAlmacen(idProducto, idAlmacen, cantidad);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/productos-almacen/{idProducto}/{idAlmacen}")
    public ResponseEntity<?> eliminarProductoAlmacen(@PathVariable int idProducto, @PathVariable int idAlmacen) {
        logger.info("Eliminando producto almacen con id "+idAlmacen+" e id_producto "+ idProducto);
        this.productoAlmacenService.eliminarProductoAlmacen(idProducto, idAlmacen);
        return ResponseEntity.ok().build();
    }
}
