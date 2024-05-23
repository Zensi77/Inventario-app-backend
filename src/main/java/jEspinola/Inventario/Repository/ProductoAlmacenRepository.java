package jEspinola.Inventario.Repository;

import jEspinola.Inventario.Model.ProductoAlmacen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface ProductoAlmacenRepository extends JpaRepository<ProductoAlmacen, Integer>{

    @Query(value = "SELECT * FROM producto_almacen WHERE id_almacen = ?1", nativeQuery = true)
    public List<ProductoAlmacen> listarProductosAlmacen(int idAlmacen);

    @Query(value = "UPDATE producto_almacen SET cantidad = ?3 WHERE id_producto = ?1 AND id_almacen = ?2", nativeQuery = true)
    public void actualizarProductoAlmacen(int producto, int almacen, int cantidad);

    @Query(value = "DELETE FROM producto_almacen WHERE id_producto = ?1 AND id_almacen = ?2", nativeQuery = true)
    public void eliminarProductoAlmacen(int idProducto, int idAlmacen);
}
