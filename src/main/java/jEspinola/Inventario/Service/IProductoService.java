package jEspinola.Inventario.Service;

import jEspinola.Inventario.Model.Producto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IProductoService {
    public List<Producto> listarProductos();
    public Producto buscarProducto(int id);
    public Producto registrarProducto(Producto producto);
    public void eliminarProducto(int idProducto);
}
