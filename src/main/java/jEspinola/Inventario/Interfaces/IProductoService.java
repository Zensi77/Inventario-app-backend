package jEspinola.Inventario.Interfaces;

import jEspinola.Inventario.Model.Producto;

import java.util.List;

public interface IProductoService {
    public List<Producto> listarProductos();
    public Producto buscarProducto(int id);
    public Producto registrarProducto(Producto producto);
    public void eliminarProducto(int idProducto);
    public void modificarCantidad(int id, boolean incrementar);
}
