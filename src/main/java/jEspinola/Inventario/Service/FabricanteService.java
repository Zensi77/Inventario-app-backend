package jEspinola.Inventario.Service;

import jEspinola.Inventario.Model.Fabricante;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // Se indica que esta clase es un servicio, es decir, se encarga de la lógica de negocio
public class FabricanteService implements IFabricanteService{
    @Override
    public List<Fabricante> listarFabricantes() {
        return null;
    }

    @Override
    public void registrarFabricante(Fabricante fabricante) {

    }

    @Override
    public void modificarFabricante(Fabricante fabricante, int id) {

    }

    @Override
    public void eliminarFabricante(Fabricante fabricante) {

    }
}
