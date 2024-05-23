package jEspinola.Inventario.Interfaces;

import jEspinola.Inventario.Model.Almacen;
import jEspinola.Inventario.Model.Producto;
import jEspinola.Inventario.Model.ProductoAlmacen;

import java.util.List;

public interface IProductoAlmacenService {
    public void registrarProductoAlmacen(ProductoAlmacen productoAlmacen);
    public void eliminarProductoAlmacen(Producto producto, Almacen almacen);
    public void actualizarProductoAlmacen(int producto, int almacen, int cantidad);
    public List<ProductoAlmacen> listarProductosAlmacen(int idAlmacen);
}
