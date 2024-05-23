package jEspinola.Inventario.Interfaces;

import jEspinola.Inventario.Model.Almacen;

import java.util.List;

public interface IAlmacenService {
    public List<Almacen> listarAlmacenes();
    public Almacen registrarAlmacen(Almacen almacen);
    public void eliminarAlmacen(int idAlmacen);
}
