package jEspinola.Inventario.Service;

import jEspinola.Inventario.Model.Fabricante;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IFabricanteService {
    public List<Fabricante> listarFabricantes();
    public Fabricante registrarFabricante(Fabricante fabricante);
    public void eliminarFabricante(int id);
}
