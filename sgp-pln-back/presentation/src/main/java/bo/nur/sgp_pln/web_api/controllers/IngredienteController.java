package bo.nur.sgp_pln.web_api.controllers;

import bo.nur.core.results.Result;
import bo.nur.sgp_pln.application.ingrediente.CreateIngredienteCommand;
import bo.nur.sgp_pln.application.ingrediente.DeleteIngredienteCommand;
import bo.nur.sgp_pln.application.ingrediente.GetIngredienteCommand;
import bo.nur.sgp_pln.application.ingrediente.UpdateIngredienteCommand;
import bo.nur.sgp_pln.domain.ingrediente.Ingrediente;
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

    @GET
    @Path("/{id}")
    public CompletionStage<Result<Ingrediente>> get(@PathParam("id") UUID id) {
        GetIngredienteCommand command = new GetIngredienteCommand(id);
        Result<Ingrediente> result = (Result<Ingrediente>) mediator.handle(command).join();
        return CompletableFuture.completedFuture(result);
    }

    @POST
    @Path("")
    public CompletionStage<Result<UUID>> create(CreateIngredienteCommand command) {
        Result<UUID> result = (Result<UUID>) mediator.handle(command).join();
        return CompletableFuture.completedFuture(result);
    }

    @PATCH
    @Path("")
    public CompletionStage<Result<Ingrediente>> update(UpdateIngredienteCommand command) {
        Result<Ingrediente> result = (Result<Ingrediente>) mediator.handle(command).join();
        return CompletableFuture.completedFuture(result);
    }

    @DELETE
    @Path("/{id}")
    public CompletionStage<Result<Ingrediente>> delete(@PathParam("id") UUID id) {
        DeleteIngredienteCommand command = new DeleteIngredienteCommand(id);
        Result<Ingrediente> result = (Result<Ingrediente>) mediator.handle(command).join();
        return CompletableFuture.completedFuture(result);
    }


}
