package jEspinola.Inventario.Interfaces;

import jEspinola.Inventario.Model.Producto;

import java.util.List;

public interface IProductoService {
    List<Producto> listarProductos();

    Producto buscarProductoId(int idProducto);

    Producto buscarProductoParametro(String cadena);

    void registrarProducto(Producto producto);

    void eliminarProducto(int idProducto);
}
