package jEspinola.Inventario.Repository;

import jEspinola.Inventario.Model.Almacen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlmacenRepository extends JpaRepository<Almacen, Integer> {
}
