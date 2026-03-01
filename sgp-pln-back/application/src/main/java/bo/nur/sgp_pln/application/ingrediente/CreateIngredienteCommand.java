package bo.nur.sgp_pln.application.ingrediente;

import bo.nur.sgp_pln.application.mediator.IRequest;
import bo.nur.sgp_pln.domain.shared.UnidadMedida;

import java.math.BigDecimal;
import java.util.List;

public record CreateIngredienteCommand(String nombre, String descripcion, String tipo,
                                       List<CreateInformacionNutricionalCommand> informacionNutricional) implements IRequest {

    public record CreateInformacionNutricionalCommand(String tipo, BigDecimal valor, UnidadMedida unidadMedida) {
    }
}
