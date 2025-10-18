package bo.nur.sgp_pln.domain.plan_alimentario;

import bo.nur.core.abstractions.Entity;
import bo.nur.sgp_pln.domain.ingrediente.InformacionNutricional;
import bo.nur.sgp_pln.domain.ingrediente.Ingrediente;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter
public class TiempoComidaReceta extends Entity {
    private UUID idReceta;
    private Integer porcion;

    public TiempoComidaReceta() {
        super();
    }

    private TiempoComidaReceta(UUID id, UUID idReceta, Integer porcion) {
        super(id);
        this.idReceta = idReceta;
        this.porcion = porcion;
    }

    public static TiempoComidaReceta create(UUID id, UUID idReceta, Integer porcion) {
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }
        if (idReceta == null) {
            throw new IllegalArgumentException("idReceta cannot be null");
        }
        if (porcion == null || porcion <= 0) {
            throw new IllegalArgumentException("porcion cannot be null or minor equal zero");
        }
        return new TiempoComidaReceta(id, idReceta, porcion);
    }
}
