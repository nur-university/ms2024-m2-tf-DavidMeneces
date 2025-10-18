package bo.nur.sgp_pln.application.ingrediente;

import bo.nur.sgp_pln.application.mediator.IRequest;
import bo.nur.sgp_pln.domain.shared.UnidadMedida;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public record UpdateIngredienteCommand(UUID id, String nombre, String descripcion, String tipo,
                                       List<UpdateInformacionNutricionalCommand> informacionNutricional) implements IRequest {
    public record UpdateInformacionNutricionalCommand(String tipo, BigDecimal valor, UnidadMedida unidadMedida) {
    }
}
