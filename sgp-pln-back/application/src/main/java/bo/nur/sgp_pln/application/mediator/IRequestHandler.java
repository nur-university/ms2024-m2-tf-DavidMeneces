package bo.nur.sgp_pln.application.mediator;

import java.util.concurrent.CompletableFuture;

public interface IRequestHandler<T extends IRequest, R extends Object> {

    CompletableFuture<R> handle(T request);
}
