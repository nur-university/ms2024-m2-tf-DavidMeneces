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
public class CreateIngredienteHandler implements IRequestHandler<CreateIngredienteCommand, Result<UUID>> {

    private IIngredienteRepository repository;

    @Inject
    public CreateIngredienteHandler(IIngredienteRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public CompletableFuture<Result<UUID>> handle(CreateIngredienteCommand request) {
        List<InformacionNutricional> informacionNutricionalList = buildInformacionNutricionalList(request.informacionNutricional());
        var ingrediente = Ingrediente.create(UUID.randomUUID(),
                request.nombre(), request.descripcion(), request.tipo(), informacionNutricionalList);
        repository.insert(ingrediente);
        var result = Result.<UUID>builder().success(Boolean.TRUE)
                .data(ingrediente.getId())
                .build();
        return CompletableFuture.completedFuture(result);
    }

    private List<InformacionNutricional> buildInformacionNutricionalList(List<CreateIngredienteCommand.CreateInformacionNutricionalCommand> requestList) {
        return (requestList != null) ? requestList.stream()
                .map(request -> InformacionNutricional.create(UUID.randomUUID(), request.tipo(), request.unidadMedida(), request.valor()))
                .toList() : new ArrayList<>();
    }
}
