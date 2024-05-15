package jEspinola.Inventario.Repository;

import jEspinola.Inventario.Model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Integer>{ // Se indica que se va a trabajar con la entidad Producto y el tipo de dato de la llave primaria es Integer
    //JPA Repository ya tiene implementado los métodos CRUD

}
