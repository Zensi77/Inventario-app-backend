package jEspinola.Inventario.Service;

import jEspinola.Inventario.Interfaces.IProductoService;
import jEspinola.Inventario.Model.Producto;
import jEspinola.Inventario.Repository.ProductoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.sql.*;

@Service // Se indica que esta clase es un servicio, es decir, se encarga de la lógica de negocio
public class ProductoService implements IProductoService {
    @Autowired // Se inyecta la dependencia de ProductoRepository
    private ProductoRepository productoRepository;

    @Override
    public List<Producto> listarProductos() {
        return this.productoRepository.findAll(); // Se obtienen todos los productos
    }

    @Override
    public Producto buscarProductoId(int idProducto) {
        return this.productoRepository.findById(idProducto).get(); // Se obtiene el producto por su id
    }

    @Override
    public Producto buscarProductoParametro(String cadena) {
        Producto producto = new Producto();
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:330/inventario", "root", "root");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM producto WHERE nombre LIKE '%" + cadena + "%'");
            if (rs.next()) {
                producto.setId_producto(rs.getInt("id_producto"));
                producto.setNombre(rs.getString("nombre"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setPrecio(rs.getDouble("precio"));
                return producto;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return producto;
    }

    @Override
    public void registrarProducto(Producto producto) {
        this.productoRepository.save(producto); // Se guarda el producto
    }

    @Override
    public void eliminarProducto(int idProducto) {
        this.productoRepository.deleteById(idProducto);
    }

}
