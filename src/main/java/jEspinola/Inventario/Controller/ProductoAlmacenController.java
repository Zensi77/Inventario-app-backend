package jEspinola.Inventario.Controller;

import jEspinola.Inventario.Model.ProductoAlmacen;
import jEspinola.Inventario.Service.ProductoAlmacenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/inventario-app")
@CrossOrigin(origins = "localhost:4200")
public class ProductoAlmacenController {

    @Autowired
    private ProductoAlmacenService productoAlmacenService;

    @GetMapping("/productos-almacen/{idAlmacen}")
    public List<ProductoAlmacen> listarProductosAlmacen(int idAlmacen) {
        return this.productoAlmacenService.listarProductosAlmacen(idAlmacen);
    }
}
