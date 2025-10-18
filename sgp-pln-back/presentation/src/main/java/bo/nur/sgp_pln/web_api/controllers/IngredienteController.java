package bo.nur.sgp_pln.web_api.controllers;

import bo.nur.core.results.Result;
import bo.nur.sgp_pln.application.ingrediente.CreateIngredienteCommand;
import bo.nur.sgp_pln.web_api.Mediator;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

@Path("/ingrediente")
public class IngredienteController {

    @Inject
    Mediator mediator;

    @POST
    @Path("")
    public CompletionStage<Result<UUID>> create(CreateIngredienteCommand command) {
        Result<UUID> result = (Result<UUID>) mediator.handle(command).join();
        return CompletableFuture.completedFuture(result);
    }


}
