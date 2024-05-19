package jEspinola.Inventario.Service;

import jEspinola.Inventario.Interfaces.IProductoService;
import jEspinola.Inventario.Model.Producto;
import jEspinola.Inventario.Repository.FabricanteRepository;
import jEspinola.Inventario.Repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.sql.*;
import java.util.UUID;

@Service // Se indica que esta clase es un servicio, es decir, se encarga de la lógica de negocio
public class ProductoService implements IProductoService {
    @Autowired // Se inyecta la dependencia de ProductoRepository
    private ProductoRepository productoRepository;

    @Autowired
    private FabricanteRepository fabricanteRepository;

    @Value("${file.upload-dir}") // Indica la ruta donde se guardarán las imágenes
    private String uploadDir;

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
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventario", "root", "root");
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
        if (producto.getFabricante() != null) { // Si el producto tiene un fabricante
            producto.setFabricante(fabricanteRepository.findById(producto.getFabricante().getId_fabricante()).orElse(null));
        }
        this.productoRepository.save(producto); // Se guarda el producto
    }

    @Override
    public void eliminarProducto(int idProducto) {
        this.productoRepository.deleteById(idProducto);
    }

    public String guardarImagen(Producto producto, MultipartFile fileImg) throws IOException {
        String fileName = UUID.randomUUID() + "_" + fileImg.getOriginalFilename(); // Se genera un nombre único para la imagen
        Path filePath = Paths.get(uploadDir, fileName); // Se crea la ruta donde se guardará la imagen

        if (!Files.exists(filePath.getParent())) {
            Files.createDirectories(filePath.getParent());
        }

        Files.copy(fileImg.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING); // Se guarda la imagen en la ruta especificada
        producto.setImagen(uploadDir + fileName); // Se guarda la ruta de la imagen en la base de datos
        return uploadDir + fileName;
    }
}


