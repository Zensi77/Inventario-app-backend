package jEspinola.Inventario.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import jakarta.persistence.EmbeddedId;


@Entity // Indica que esta clase es una entidad
@NoArgsConstructor // Genera un constructor vacío
@AllArgsConstructor // Genera un constructor con todos los argumentos
@Data // Genera todos los getters y setters
@ToString // Genera el método toString
public class Producto {
    @EmbeddedId // Indica que este campo es la llave primaria compuesta por dos campos
    private ProductoId id;

    @ManyToOne // Indica que esta relación es de muchos a uno
    @JoinColumn(name = "id_almacen", updatable = false, insertable = false) // Indica el nombre de la columna en la base de datos
    private Almacen almacen;

    @Column(name = "nombre") // Indica el nombre de la columna en la base de datos
    private String nombre;

    @Column(name = "descripcion") // Indica el nombre de la columna en la base de datos
    private String descripcion;

    @Column(name = "precio") // Indica el nombre de la columna en la base de datos
    private double precio;

    @Column(name = "existencia") // Indica el nombre de la columna en la base de datos
    private int existencia;

    @ManyToOne // Indica que esta relación es de muchos a uno
    @JoinColumn(name="id_fabricante", referencedColumnName = "id_fabricante") // Indica el nombre de la columna en la base de datos
    private Fabricante fabricante;
}

