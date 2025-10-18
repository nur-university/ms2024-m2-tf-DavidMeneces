package bo.nur.core.abstractions;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public abstract class Entity {
    public UUID id;
    private List<DomainEvent> domainEvents;

    public Entity(UUID id) {
        if (id == null) {
            throw new IllegalArgumentException("Id cannot by null");
        }
        this.id = id;
        domainEvents = new ArrayList<>();
    }

    protected Entity() {
        this.domainEvents = new ArrayList<>();
    }

    public void addDomainEvent(DomainEvent domainEvent) {
        this.domainEvents.add(domainEvent);
    }

    public void clearDomainEvents() {
        this.domainEvents.clear();
    }


}
