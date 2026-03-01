package bo.nur.sgp_pln.application.receta;

import bo.nur.sgp_pln.application.mediator.IRequest;

import java.util.List;
import java.util.UUID;

public record CreateRecetaCommand(String nombre, String descripcion, String instrucciones, List<RecetaIngredienteCommand> ingredientes) implements IRequest {

    public record RecetaIngredienteCommand(UUID idIngrediente, Integer cantidad) {
    }
}
