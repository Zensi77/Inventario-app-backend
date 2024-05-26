package jEspinola.Inventario.Repository;

import jEspinola.Inventario.Model.ProductoAlmacen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface ProductoAlmacenRepository extends JpaRepository<ProductoAlmacen, Integer>{

    @Query(value = "SELECT * FROM producto_almacen WHERE id_almacen = ?1", nativeQuery = true)
    List<ProductoAlmacen> listarProductosAlmacen(int idAlmacen);
}
