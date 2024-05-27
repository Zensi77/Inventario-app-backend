package jEspinola.Inventario.Interfaces;

import jEspinola.Inventario.Model.ProductoAlmacen;

import java.util.List;

public interface IProductoAlmacenService {
    void registrarProductoAlmacen(ProductoAlmacen productoAlmacen);

    void eliminarProductoAlmacen(int idProducto, int idAlmacen);

    void actualizarProductoAlmacen(int producto, int almacen, int cantidad);

    List<ProductoAlmacen> listarProductosAlmacen(int idAlmacen);
}
