package jEspinola.Inventario.Repository;

import jEspinola.Inventario.Model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Integer> { // Se indica que se va a trabajar con la entidad Producto y el tipo de dato de la llave primaria es Integer
    //JPA Repository ya tiene implementado los métodos CRUD

    // Se crea un método personalizado para buscar todos los productos que no estén eliminados y que su fabricante esté eliminado O no esté eliminado
    @Query("Select p FROM Producto p WHERE p.isDeleted = false AND p.fabricante.isDeleted = false")
    List<Producto> findAll();
}
