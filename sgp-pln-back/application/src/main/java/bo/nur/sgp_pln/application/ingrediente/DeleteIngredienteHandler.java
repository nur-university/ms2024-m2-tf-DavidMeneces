package bo.nur.sgp_pln.application.ingrediente;

import bo.nur.core.results.Result;
import bo.nur.sgp_pln.application.mediator.IRequestHandler;
import bo.nur.sgp_pln.domain.ingrediente.IIngredienteRepository;
import bo.nur.sgp_pln.domain.ingrediente.InformacionNutricional;
import bo.nur.sgp_pln.domain.ingrediente.Ingrediente;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RequestScoped
public class DeleteIngredienteHandler implements IRequestHandler<DeleteIngredienteCommand, Result<Boolean>> {

    private IIngredienteRepository repository;

    @Inject
    public DeleteIngredienteHandler(IIngredienteRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public CompletableFuture<Result<Boolean>> handle(DeleteIngredienteCommand request) {
        repository.delete(request.id());
        var result = Result.<Boolean>builder().success(Boolean.TRUE)
                .data(Boolean.TRUE)
                .build();
        return CompletableFuture.completedFuture(result);
    }
}
