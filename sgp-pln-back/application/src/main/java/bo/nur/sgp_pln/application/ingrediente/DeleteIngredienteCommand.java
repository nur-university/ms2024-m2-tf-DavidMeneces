package bo.nur.sgp_pln.application.ingrediente;

import bo.nur.sgp_pln.application.mediator.IRequest;

import java.util.UUID;

public record DeleteIngredienteCommand(UUID id) implements IRequest {
}
