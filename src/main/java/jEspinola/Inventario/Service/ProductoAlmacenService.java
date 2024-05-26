package jEspinola.Inventario.Service;

import jEspinola.Inventario.Interfaces.IProductoAlmacenService;
import jEspinola.Inventario.Model.Almacen;
import jEspinola.Inventario.Model.Producto;
import jEspinola.Inventario.Model.ProductoAlmacen;
import jEspinola.Inventario.Repository.ProductoAlmacenRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductoAlmacenService implements IProductoAlmacenService {

    @Autowired
    private ProductoAlmacenRepository productoAlmacenRepository;

    public void registrarProductoAlmacen(ProductoAlmacen productoAlmacen) {
        try {
            productoAlmacenRepository.save(productoAlmacen);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Transactional
    public void eliminarProductoAlmacen(int idProducto, int idAlmacen) {
        String sql = "DELETE FROM producto_almacen WHERE id_producto = "+idProducto+" AND id_almacen = "+idAlmacen+";";
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventario", "root", "root");
            Statement stmt = con.createStatement();
            stmt.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
    public void actualizarProductoAlmacen(int producto, int almacen, int cantidad) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventario", "root", "root");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT cantidad FROM producto_almacen WHERE id_producto = "+producto+" AND id_almacen = "+almacen+";");
            if(rs.next()){
                cantidad += rs.getInt("cantidad");
            }
            stmt.executeUpdate("UPDATE producto_almacen SET cantidad = "+cantidad+" WHERE id_producto = "+producto+" AND id_almacen = "+almacen+";");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<ProductoAlmacen> listarProductosAlmacen(int idAlmacen) {
        List<ProductoAlmacen> listaProductosAlmacen = new ArrayList<>();
        try {
            listaProductosAlmacen= productoAlmacenRepository.listarProductosAlmacen(idAlmacen);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listaProductosAlmacen;
    }

    public ProductoAlmacen agregarProductoAlmacen(ProductoAlmacen productoAlmacen) {
        return productoAlmacenRepository.save(productoAlmacen);
    }
}
