package bo.nur.sgp_pln.application.plan_alimentario;

import bo.nur.core.results.Result;
import bo.nur.sgp_pln.application.mediator.IRequestHandler;
import bo.nur.sgp_pln.domain.plan_alimentario.*;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RequestScoped
public class DeletePlanAlimentarioHandler implements IRequestHandler<CreatePlanAlimentarioCommand, Result<UUID>> {

    private IPlanAlimentarioRepository repository;

    @Inject
    public DeletePlanAlimentarioHandler(IPlanAlimentarioRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public CompletableFuture<Result<UUID>> handle(CreatePlanAlimentarioCommand request) {
        List<PlanAlimentarioDia> planAlimentarioDiaList = buildPlanAlimentarioDiaList(request.planAlimentarioDias());
        var planAlimentario = PlanAlimentario.create(UUID.randomUUID(), request.dias(), planAlimentarioDiaList);
        repository.insert(planAlimentario);
        var result = Result.<UUID>builder().success(Boolean.TRUE)
                .data(planAlimentario.getId())
                .build();
        return CompletableFuture.completedFuture(result);
    }

    private List<PlanAlimentarioDia> buildPlanAlimentarioDiaList(List<CreatePlanAlimentarioCommand.PlanAlimentarioDiaCommand> requestList) {
        return (requestList != null) ? requestList.stream()
                .map(request -> PlanAlimentarioDia.create(UUID.randomUUID(), request.dia(), buildTiempoComidaList(request.tiempoComidas())))
                .toList() : new ArrayList<>();
    }

    private List<TiempoComida> buildTiempoComidaList(List<CreatePlanAlimentarioCommand.TiempoComidaCommand> requestList) {
        return (requestList != null) ? requestList.stream()
                .map(request -> TiempoComida.create(UUID.randomUUID(), request.tipo(), request.orden(),
                        buildTiempoComidaRecetaList(request.recetas())))
                .toList() : new ArrayList<>();
    }

    private List<TiempoComidaReceta> buildTiempoComidaRecetaList(List<CreatePlanAlimentarioCommand.TiempoComidaRecetaCommand> requestList) {
        return (requestList != null) ? requestList.stream()
                .map(request -> TiempoComidaReceta.create(UUID.randomUUID(), request.idReceta(), request.porcion()))
                .toList() : new ArrayList<>();
    }

}
