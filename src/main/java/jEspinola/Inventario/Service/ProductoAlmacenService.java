package jEspinola.Inventario.Service;

import jEspinola.Inventario.Interfaces.IProductoAlmacenService;
import jEspinola.Inventario.Model.Almacen;
import jEspinola.Inventario.Model.Producto;
import jEspinola.Inventario.Model.ProductoAlmacen;
import jEspinola.Inventario.Repository.ProductoAlmacenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public void eliminarProductoAlmacen(Producto producto, Almacen almacen) {
        try {
            productoAlmacenRepository.eliminarProductoAlmacen(producto.getId_producto(), almacen.getId_almacen());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actualizarProductoAlmacen(int producto, int almacen, int cantidad) {
        try {
            productoAlmacenRepository.actualizarProductoAlmacen(producto, almacen, cantidad);
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
}
