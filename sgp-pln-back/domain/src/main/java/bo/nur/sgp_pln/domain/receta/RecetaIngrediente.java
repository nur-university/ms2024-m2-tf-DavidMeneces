package bo.nur.sgp_pln.domain.receta;

import bo.nur.core.abstractions.Entity;
import lombok.Getter;

import java.util.UUID;

@Getter
public class RecetaIngrediente extends Entity {
    private UUID idIngrediente;
    private Integer cantidad;

    public RecetaIngrediente() {
        super();
    }

    private RecetaIngrediente(UUID id, UUID idIngrediente, Integer cantidad) {
        super(id);
        this.idIngrediente = idIngrediente;
        this.cantidad = cantidad;
    }

    public static RecetaIngrediente crear(UUID id, UUID idIngrediente, Integer cantidad) {
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }
        if (idIngrediente == null) {
            throw new IllegalArgumentException("idIngrediente cannot be null");
        }
        if (cantidad == null || cantidad <= 0) {
            throw new IllegalArgumentException("cantidad cannot be null and minor than zero");
        }
        return new RecetaIngrediente(id, idIngrediente, cantidad);
    }
}
