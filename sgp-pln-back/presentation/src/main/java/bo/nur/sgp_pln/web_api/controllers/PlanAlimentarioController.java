package bo.nur.sgp_pln.web_api.controllers;

import bo.nur.core.results.Result;
import bo.nur.sgp_pln.application.plan_alimentario.CreatePlanAlimentarioCommand;
import bo.nur.sgp_pln.web_api.Mediator;
import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

@Path("/reseta")
public class PlanAlimentarioController {

    @Inject
    Mediator mediator;

    @POST
    @Path("")
    public CompletionStage<Result<UUID>> create(CreatePlanAlimentarioCommand command) {
        Result<UUID> result = (Result<UUID>) mediator.handle(command).join();
        return CompletableFuture.completedFuture(result);
    }
}
