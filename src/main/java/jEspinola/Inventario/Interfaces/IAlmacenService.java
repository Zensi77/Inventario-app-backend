package jEspinola.Inventario.Interfaces;

import jEspinola.Inventario.Model.Almacen;

import java.util.List;

public interface IAlmacenService {
    List<Almacen> listarAlmacenes();

    Almacen registrarAlmacen(Almacen almacen);

    void eliminarAlmacen(int idAlmacen);
}
