package jEspinola.Inventario.Service;

import jEspinola.Inventario.Model.Fabricante;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IFabricanteService {
    public List<Fabricante> listarFabricantes();
    public void registrarFabricante(Fabricante fabricante);
    public void modificarFabricante(Fabricante fabricante, int id);
    public void eliminarFabricante(Fabricante fabricante);
}
