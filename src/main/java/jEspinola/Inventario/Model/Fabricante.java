package jEspinola.Inventario.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity // Indica que esta clase es una entidad
@NoArgsConstructor // Genera un constructor vacío
@AllArgsConstructor // Genera un constructor con todos los argumentos
@Data // Genera todos los getters y setters
@ToString // Genera el método toString
public class Fabricante {
    @Id // Indica que este campo es la llave primaria
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY) // Indica que este campo es autoincrementable
    @Column(name = "id_fabricante") // Indica el nombre de la columna en la base de datos
    private int id_fabricante;

    @Column(name = "nombre") // Indica el nombre de la columna en la base de datos
    private String nombre;

    @Column(name = "direccion") // Indica el nombre de la columna en la base de datos
    private String direccion;

    @Column(name = "telefono") // Indica el nombre de la columna en la base de datos
    private String telefono;
}
