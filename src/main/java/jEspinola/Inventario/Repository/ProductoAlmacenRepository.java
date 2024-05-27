package jEspinola.Inventario.Repository;

import jEspinola.Inventario.Model.ProductoAlmacen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface ProductoAlmacenRepository extends JpaRepository<ProductoAlmacen, Integer> {

    @Query("SELECT pa FROM ProductoAlmacen pa WHERE pa.almacen.id_almacen = ?1 AND pa.producto.isDeleted = false")
    List<ProductoAlmacen> listarProductosAlmacen(int idAlmacen);
}
