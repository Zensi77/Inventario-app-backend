package jEspinola.Inventario.Service;

import jEspinola.Inventario.Interfaces.IAlmacenService;
import jEspinola.Inventario.Model.Almacen;
import jEspinola.Inventario.Repository.AlmacenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlmacenService implements IAlmacenService {

    @Autowired // Inyección de dependencias
    private AlmacenRepository almacenRepository;

    @Override
    public List<Almacen> listarAlmacenes() {
        return almacenRepository.findAll();
    }

    @Override
    public Almacen buscarAlmacen(int id) {
        return almacenRepository.findById(id).orElse(null);
    }

    @Override
    public Almacen registrarAlmacen(Almacen almacen) {
        return almacenRepository.save(almacen); // Guarda si no existe, actualiza si existe
    }

    @Override
    public void eliminarAlmacen(int idAlmacen) {
        almacenRepository.deleteById(idAlmacen);
    }

}
