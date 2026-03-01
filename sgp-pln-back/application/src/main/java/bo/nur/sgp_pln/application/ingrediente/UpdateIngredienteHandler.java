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
public class UpdateIngredienteHandler implements IRequestHandler<UpdateIngredienteCommand, Result<Boolean>> {

    private IIngredienteRepository repository;

    @Inject
    public UpdateIngredienteHandler(IIngredienteRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public CompletableFuture<Result<Boolean>> handle(UpdateIngredienteCommand request) {
        List<InformacionNutricional> informacionNutricionalList = buildInformacionNutricionalList(request.informacionNutricional());
        var ingrediente = Ingrediente.create(request.id(), request.nombre(), request.descripcion(), request.tipo(), informacionNutricionalList);
        repository.update(ingrediente);
        var result = Result.<Boolean>builder().success(Boolean.TRUE)
                .data(Boolean.TRUE)
                .build();
        return CompletableFuture.completedFuture(result);
    }

    private List<InformacionNutricional> buildInformacionNutricionalList(List<UpdateIngredienteCommand.UpdateInformacionNutricionalCommand> requestList) {
        return (requestList != null) ? requestList.stream()
                .map(request -> InformacionNutricional.create(UUID.randomUUID(), request.tipo(), request.unidadMedida(), request.valor()))
                .toList() : new ArrayList<>();
    }

}
