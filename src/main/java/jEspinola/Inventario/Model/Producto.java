package jEspinola.Inventario.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;


/***
 * Clase que representa la entidad Producto
 * @Entity: Indica que esta clase es una entidad
 * @NoArgsConstructor: Genera un constructor vacío
 * @AllArgsConstructor: Genera un constructor con todos los argumentos
 * @Data: Genera todos los getters y setters
 * @ToString: Genera el método toString
 * https://refactorizando.com/soft-delete-hibernate-spring-boot/
 * @SQLDelete: Se utiliza para realizar un borrado lógico en lugar de un borrado físico
 * @Where: Se utiliza para filtrar los registros eliminados lógicamente
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@SQLDelete(sql = "UPDATE producto SET is_deleted = true WHERE id_producto = ?")
@Where(clause = "is_deleted = false")
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

    @Lob // Indica que este campo es de tipo BLOB(Binario)
    @Column(name = "imagen", columnDefinition = "text default null")
    private String imagen;

    @Column(name = "mime_type", columnDefinition = "text default null") // Nuevo campo para almacenar el tipo MIME de la imagen (image/png, image/jpeg, etc.)
    private String mimeType; // Nuevo campo para almacenar el tipo MIME

    @ManyToOne // Indica que esta relación es de muchos a uno
    @JoinColumn(name = "id_fabricante", referencedColumnName = "id_fabricante")
    private Fabricante fabricante;

    @Column(name= "is_deleted", columnDefinition = "boolean default false")
    private boolean isDeleted;
}

