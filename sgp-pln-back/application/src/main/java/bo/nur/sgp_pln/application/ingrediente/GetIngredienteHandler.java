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
public class GetIngredienteHandler implements IRequestHandler<GetIngredienteCommand, Result<Ingrediente>> {

    private IIngredienteRepository repository;

    @Inject
    public GetIngredienteHandler(IIngredienteRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public CompletableFuture<Result<Ingrediente>> handle(GetIngredienteCommand request) {
        var ingrediente = repository.getById(request.id());
        var result = Result.<Ingrediente>builder().success(Boolean.TRUE)
                .data(ingrediente)
                .build();
        return CompletableFuture.completedFuture(result);
    }

}
