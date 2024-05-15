package jEspinola.Inventario.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity // Indica que esta clase es una entidad
@NoArgsConstructor // Genera un constructor vacío
@AllArgsConstructor // Genera un constructor con todos los argumentos
@Data // Genera todos los getters y setters
@ToString // Genera el método toString
public class Producto {

    @Id // Indica que este campo es la llave primaria
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private int id_producto;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "precio")
    private double precio;

    @ManyToOne // Indica que esta relación es de muchos a uno
    @JoinColumn(name = "id_fabricante", referencedColumnName = "id_fabricante")
    private Fabricante fabricante;


}

