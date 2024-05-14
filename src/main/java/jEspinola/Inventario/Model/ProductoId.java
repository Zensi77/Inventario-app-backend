package jEspinola.Inventario.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@AllArgsConstructor // Genera un constructor con todos los argumentos
@NoArgsConstructor // Genera un constructor vacío
@Data // Genera todos los getters y setters
@Embeddable // Indica que esta clase es embebida en otra entidad, es decir, no tiene una tabla propia
public class ProductoId implements Serializable {
    private String idProducto;
    private int id_almacen;
}
