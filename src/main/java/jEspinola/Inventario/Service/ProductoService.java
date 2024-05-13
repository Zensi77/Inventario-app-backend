package jEspinola.Inventario.Service;

import jEspinola.Inventario.Interfaces.IProductoService;
import jEspinola.Inventario.Model.Producto;
import jEspinola.Inventario.Repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public Producto registrarProducto(Producto producto) {
        return this.productoRepository.save(producto); // Se guarda el producto
        // Si el producto ya existe(id), se actualiza la información por lo que no necesito un método para actualizar
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
