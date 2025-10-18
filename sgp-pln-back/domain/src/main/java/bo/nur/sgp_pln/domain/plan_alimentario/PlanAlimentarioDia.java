package bo.nur.sgp_pln.domain.plan_alimentario;

import bo.nur.core.abstractions.Entity;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter
public class PlanAlimentarioDia extends Entity {
    private Integer dia;
    private List<TiempoComida> tiempoComidas;

    private PlanAlimentarioDia() {
        super();
    }

    private PlanAlimentarioDia(UUID id, Integer dia, List<TiempoComida> tiempoComidas) {
        super(id);
        this.dia = dia;
        this.tiempoComidas = tiempoComidas;
    }

    public static PlanAlimentarioDia create(UUID id, Integer dia, List<TiempoComida> tiempoComidas) {
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }
        if (dia == null) {
            throw new IllegalArgumentException("dia cannot be null");
        }
        if (tiempoComidas == null || tiempoComidas.isEmpty()) {
            throw new IllegalArgumentException("tiempoComidas cannot be null or empty");
        }
        return new PlanAlimentarioDia(id, dia, tiempoComidas);
    }
}
