package bo.nur.sgp_pln.application.mediator;

import java.util.concurrent.CompletableFuture;

public interface IMediator {
    <T extends IRequest, R> CompletableFuture<R> handle(T request);
}
