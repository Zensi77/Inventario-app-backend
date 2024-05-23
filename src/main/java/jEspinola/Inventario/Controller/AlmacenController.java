package jEspinola.Inventario.Controller;

import jEspinola.Inventario.Model.Almacen;
import jEspinola.Inventario.Model.Producto;
import jEspinola.Inventario.Service.AlmacenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/inventario-app")
@CrossOrigin(origins = "localhost:4200")
public class AlmacenController {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(ProductoController.class);

    @Autowired
    private AlmacenService almacenService;

    @GetMapping("/almacenes")
    public List<Almacen> listarAlmacenes() {
        List<Almacen> almacenes = this.almacenService.listarAlmacenes();
        logger.info("Listando almacenes");
        return almacenes;
    }

    @GetMapping("/almacenes/{idAlmacen}")
    public List<Producto> listarProductosPorAlmacen(@PathVariable int idAlmacen) {
        List<Producto> productos = this.almacenService.listarProductosPorAlmacen(idAlmacen);
        logger.info("Listando productos del almacen con id: " + idAlmacen);
        return productos;
    }

    @PostMapping("/almacenes")
    public void registrarAlmacen(@RequestBody Almacen almacen) {
        logger.info("Registrando almacen");
        logger.info(almacen.toString());
        this.almacenService.registrarAlmacen(almacen);
    }

    @PostMapping
    public List<Producto> listarArticulosPorAlmacen(@RequestBody Almacen almacen) {
        logger.info("Listando articulos por almacen");
        logger.info(almacen.toString());
        return this.almacenService.listarProductosPorAlmacen(almacen.getId_almacen());
    }

    @DeleteMapping("/almacenes/{idAlmacen}")
    public void eliminarAlmacen(@PathVariable int idAlmacen) {
        logger.info("Eliminando almacen con id: " + idAlmacen);
        this.almacenService.eliminarAlmacen(idAlmacen);
    }

    @PutMapping("/almacenes/{idAlmacen}")
    public void actualizarAlmacen(@PathVariable int idAlmacen, @RequestBody Almacen almacen) {
        logger.info("Actualizando almacen con id: " + idAlmacen);
        logger.info(almacen.toString());
        this.almacenService.registrarAlmacen(almacen);
    }
}
