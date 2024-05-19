package jEspinola.Inventario.Service;

import jEspinola.Inventario.Interfaces.IFabricanteService;
import jEspinola.Inventario.Model.Fabricante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jEspinola.Inventario.Repository.FabricanteRepository;

import java.util.List;

@Service // Se indica que esta clase es un servicio, es decir, se encarga de la lógica de negocio
public class FabricanteService implements IFabricanteService {
    @Autowired // Se inyecta la dependencia de FabricanteRepository
    private FabricanteRepository fabricanteRepository;

    @Override
    public List<Fabricante> listarFabricantes() {
        return fabricanteRepository.findAll();
    }

    public Fabricante obtenerFabricante(int idFabricante) {
        return fabricanteRepository.findById(idFabricante).orElse(null);
    }


    @Override
    public Fabricante registrarFabricante(Fabricante fabricante) {
        return fabricanteRepository.save(fabricante); // Se guarda el fabricante
    }

    @Override
    public void eliminarFabricante(int idFabricante) {
        fabricanteRepository.deleteById(idFabricante);
    }

}
