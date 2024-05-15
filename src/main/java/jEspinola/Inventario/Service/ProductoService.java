package jEspinola.Inventario.Service;

import jEspinola.Inventario.Interfaces.IProductoService;
import jEspinola.Inventario.Model.Almacen;
import jEspinola.Inventario.Model.Producto;
import jEspinola.Inventario.Repository.ProductoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jEspinola.Inventario.Service.AlmacenService;

import java.util.List;
import java.util.Optional;

@Service // Se indica que esta clase es un servicio, es decir, se encarga de la lógica de negocio
public class ProductoService implements IProductoService {
    @Autowired // Se inyecta la dependencia de ProductoRepository
    private ProductoRepository productoRepository;

    @Override
    public List<Producto> listarProductos() {
        return this.productoRepository.findAll(); // Se obtienen todos los productos
    }

    public Producto buscarProducto(int id) {
        return this.productoRepository.findById(id).orElse(null); // Se obtiene el producto por su id
    }

    @Override
    @Transactional // Se indica que este método es transaccional, es decir, se ejecuta todo o nada
    public void registrarProducto(Producto producto) {
        this.productoRepository.save(producto); // Se guarda el producto
    }

    @Override
    public void eliminarProducto(int idProducto) {
        this.productoRepository.deleteById(idProducto);
    }

    @Override
    public void modificarCantidad(int id, boolean incrementar) {
    }
}
