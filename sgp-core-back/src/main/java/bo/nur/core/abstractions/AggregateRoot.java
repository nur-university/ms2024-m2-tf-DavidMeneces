package bo.nur.core.abstractions;

import java.util.UUID;

public abstract class AggregateRoot extends Entity {
    public AggregateRoot(UUID id) {
        super(id);
    }

    public AggregateRoot() {
        super();
    }
}
