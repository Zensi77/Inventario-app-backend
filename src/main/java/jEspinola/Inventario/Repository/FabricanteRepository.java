package jEspinola.Inventario.Repository;

import jEspinola.Inventario.Model.Fabricante;
import org.springframework.data.jpa.repository.JpaRepository;

// Esta interfaz se encarga de realizar las operaciones CRUD en la base de datos
public interface FabricanteRepository extends JpaRepository<Fabricante, Integer> {
}
