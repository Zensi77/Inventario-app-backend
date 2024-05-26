package jEspinola.Inventario.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@IdClass(ProductoAlmacen.class) // Indica que esta clase es una entidad y que la llave primaria está compuesta por dos campos
@SQLDelete(sql = "UPDATE producto_almacen SET is_deleted = true WHERE id_producto = ? AND id_almacen = ?")
@Where(clause = "is_deleted = false")
public class ProductoAlmacen {
    @Id
    @ManyToOne(cascade = {CascadeType.ALL}) // Indica que esta relación es de muchos a uno
    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto") // Indica el nombre de la columna en la base de datos
    private Producto producto;

    @Id
    @ManyToOne(cascade = {CascadeType.ALL}) // Indica que esta relación es de muchos a uno
    @JoinColumn(name = "id_almacen", referencedColumnName = "id_almacen") // Indica el nombre de la columna en la base de datos
    private Almacen almacen;

    @Column(name = "cantidad")
    private int cantidad;

    @Column(name = "is_deleted", columnDefinition = "boolean default false")
    private boolean isDeleted;
}
