package bo.nur.sgp_pln.application.plan_alimentario;

import bo.nur.sgp_pln.application.mediator.IRequest;
import bo.nur.sgp_pln.domain.shared.TipoTiempoComida;

import java.util.List;
import java.util.UUID;

public record CreatePlanAlimentarioCommand(Integer dias, List<PlanAlimentarioDiaCommand> planAlimentarioDias) implements IRequest {
    public record PlanAlimentarioDiaCommand(Integer dia, List<TiempoComidaCommand> tiempoComidas) {
    }
    public record TiempoComidaCommand(TipoTiempoComida tipo, Integer orden, List<TiempoComidaRecetaCommand> recetas) {
    }
    public record TiempoComidaRecetaCommand(UUID idReceta, Integer porcion) {
    }
}
