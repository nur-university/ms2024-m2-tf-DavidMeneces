package bo.nur.sgp_pln.domain.ingrediente;

import bo.nur.core.abstractions.AggregateRoot;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter
public class Ingrediente extends AggregateRoot {
    private String nombre;
    private String descripcion;
    private String tipo;
    private List<InformacionNutricional> informacionNutricional;

    public Ingrediente() {
        super();
    }

    private Ingrediente(UUID id, String nombre, String descripcion, String tipo, List<InformacionNutricional> informacionNutricional) {
        super(id);
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.informacionNutricional = informacionNutricional;
    }

    public static Ingrediente create(UUID id, String nombre, String descripcion, String tipo, List<InformacionNutricional> informacionNutricional) {
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("nombre cannot be null or empty");
        }
        if (informacionNutricional == null || informacionNutricional.isEmpty()) {
            throw new IllegalArgumentException("informacionNutricional cannot be null or empty");
        }
        return new Ingrediente(id, nombre, descripcion, tipo, informacionNutricional);
    }
}
