package jEspinola.Inventario.Interfaces;

import jEspinola.Inventario.Model.Fabricante;

import java.util.List;

public interface IFabricanteService {
    public List<Fabricante> listarFabricantes();
    public Fabricante registrarFabricante(Fabricante fabricante);
    public void eliminarFabricante(int id);
}
