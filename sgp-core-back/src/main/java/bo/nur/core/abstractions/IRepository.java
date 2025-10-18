package bo.nur.core.abstractions;

import java.util.UUID;

public interface IRepository<T extends AggregateRoot> {

    T getById(UUID id);

    T getById(UUID id, boolean readOnly);

    void insert(T entity);
}
