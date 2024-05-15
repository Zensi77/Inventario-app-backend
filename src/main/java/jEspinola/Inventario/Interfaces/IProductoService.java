package jEspinola.Inventario.Interfaces;

import jEspinola.Inventario.Model.Producto;

import java.util.List;

public interface IProductoService {
    public List<Producto> listarProductos();
    public Producto buscarProductoId(int idProducto);
    public Producto buscarProductoParametro(String cadena);
    public void registrarProducto(Producto producto);
    public void eliminarProducto(int idProducto);
}
