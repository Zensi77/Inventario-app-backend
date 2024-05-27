package jEspinola.Inventario.Interfaces;

import jEspinola.Inventario.Model.Fabricante;

import java.util.List;

public interface IFabricanteService {
    List<Fabricante> listarFabricantes();

    Fabricante registrarFabricante(Fabricante fabricante);

    void eliminarFabricante(int id);
}
