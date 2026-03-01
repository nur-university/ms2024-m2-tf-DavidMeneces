package bo.nur.core.abstractions;

import java.util.concurrent.CompletableFuture;

public interface IUnitOfWork {
    CompletableFuture<Void> commitAsync();
}
