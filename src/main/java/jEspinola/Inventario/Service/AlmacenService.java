package jEspinola.Inventario.Service;

import jEspinola.Inventario.Interfaces.IAlmacenService;
import jEspinola.Inventario.Model.Almacen;
import jEspinola.Inventario.Model.Producto;
import jEspinola.Inventario.Model.ProductoAlmacen;
import jEspinola.Inventario.Repository.AlmacenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.*;
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

    public List<ProductoAlmacen> listarProductosPorAlmacen(int idAlmacen) {
        List<ProductoAlmacen> productos = null;
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventario", "root", "root");
            String query = "SELECT * FROM producto_almacen WHERE id_almacen = " + idAlmacen;
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return productos;
    }

    public void registrarProductoEnAlmacen(int idAlmacen, Producto producto, int cantidad) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventario", "root", "root");
            String query = "INSERT INTO producto_almacen (id_almacen, id_producto, cantidad) VALUES (?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1, idAlmacen);
            stmt.setInt(2, producto.getId_producto());
            stmt.setInt(3, cantidad);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}