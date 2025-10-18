package bo.nur.sgp_pln.application.receta;

import bo.nur.core.results.Result;
import bo.nur.sgp_pln.application.mediator.IRequestHandler;
import bo.nur.sgp_pln.domain.receta.IRecetaRepository;
import bo.nur.sgp_pln.domain.receta.Receta;
import bo.nur.sgp_pln.domain.receta.RecetaIngrediente;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Any;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RequestScoped
public class CreateRecetaHandler implements IRequestHandler<CreateRecetaCommand, Result<UUID>> {

    private IRecetaRepository repository;

    @Inject
    public CreateRecetaHandler(@Any IRecetaRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public CompletableFuture<Result<UUID>> handle(CreateRecetaCommand request) {
        List<RecetaIngrediente> recetaIngredienteList = buildRecetaIngredienteList(request.ingredientes());
        var receta = Receta.create(UUID.randomUUID(),
                request.nombre(), request.descripcion(), request.instrucciones(), recetaIngredienteList);
        repository.insert(receta);
        var result = Result.<UUID>builder().success(Boolean.TRUE)
                .data(receta.getId())
                .build();
        return CompletableFuture.completedFuture(result);
    }

    private List<RecetaIngrediente> buildRecetaIngredienteList(List<CreateRecetaCommand.RecetaIngredienteCommand> requestList) {
        return (requestList != null) ? requestList.stream()
                .map(request -> RecetaIngrediente.crear(UUID.randomUUID(), request.idIngrediente(), request.cantidad()))
                .toList() : new ArrayList<>();
    }


}
