package bo.nur.sgp_pln.domain.plan_alimentario;

import bo.nur.core.abstractions.AggregateRoot;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter
public class PlanAlimentario extends AggregateRoot {

    private Integer dias;
    private List<PlanAlimentarioDia> planAlimentarioDias;

    public PlanAlimentario() {
        super();
    }

    private PlanAlimentario(UUID id, Integer dias, List<PlanAlimentarioDia> planAlimentarioDias) {
        super(id);
        this.dias = dias;
        this.planAlimentarioDias = planAlimentarioDias;
    }

    public static PlanAlimentario create(UUID id, Integer dias, List<PlanAlimentarioDia> planAlimentarioDias) {
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }
        if (dias == null || !(dias == 15 || dias == 30)) {
            throw new IllegalArgumentException("dias value must not be zero and must be 15 and 30");
        }
        if (planAlimentarioDias == null || planAlimentarioDias.size() != dias) {
            throw new IllegalArgumentException("planAlimentarioDias cannot be null and must be same size to dias");
        }
        return new PlanAlimentario(id, dias, planAlimentarioDias);
    }
}
