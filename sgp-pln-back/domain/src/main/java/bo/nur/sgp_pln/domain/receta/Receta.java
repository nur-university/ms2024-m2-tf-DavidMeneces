package bo.nur.sgp_pln.domain.receta;

import bo.nur.core.abstractions.AggregateRoot;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter
public class Receta extends AggregateRoot {
    private String nombre;
    private String descripcion;
    private String instrucciones;
    private List<RecetaIngrediente> ingredientes;

    public Receta() {
        super();
    }

    private Receta(UUID id, String nombre, String descripcion, String instrucciones, List<RecetaIngrediente> ingredientes) {
        super(id);
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.instrucciones = instrucciones;
        this.ingredientes = ingredientes;
    }

    public static Receta create(UUID id, String nombre, String descripcion, String instrucciones, List<RecetaIngrediente> ingredientes) {
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("nombre cannot be null or empty");
        }
        if (descripcion == null || descripcion.isEmpty()) {
            throw new IllegalArgumentException("descripcion cannot be null or empty");
        }
        if (ingredientes == null || ingredientes.isEmpty()) {
            throw new IllegalArgumentException("ingredientes cannot be null or empty");
        }
        return new Receta(id, nombre, descripcion, instrucciones, ingredientes);
    }
}
