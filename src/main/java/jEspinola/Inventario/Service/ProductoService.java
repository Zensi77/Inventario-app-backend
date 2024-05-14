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

    @Autowired
    private AlmacenService almacenService;

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
        Producto productoExistente = this.productoRepository.findById(producto.getId()).orElse(null);
        if (productoExistente != null) {
            productoExistente.setExistencia(productoExistente.getExistencia() + producto.getExistencia());
            this.productoRepository.save(productoExistente); // Se guarda el producto con la nueva cantidad si ya existe
        } else {
            this.productoRepository.save(producto); // Se guarda el producto si no existe
        }
    }

    @Override
    public void eliminarProducto(int idProducto) {
        this.productoRepository.deleteById(idProducto);
    }

    @Override
    public void modificarCantidad(int id, boolean incrementar) {
        int cantidad;
        if (incrementar)  cantidad = 1;
        else  cantidad = -1;

        Producto producto = this.productoRepository.findById(id).orElse(null);
        if (producto != null) {
            producto.setExistencia(producto.getExistencia() + cantidad);
            this.productoRepository.save(producto); // Se guarda el producto con la nueva cantidad si ya existe
        }

    }
}
