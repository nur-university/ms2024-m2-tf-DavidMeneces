package bo.nur.core.abstractions;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public abstract class DomainEvent {
    public UUID id;
    public LocalDateTime occuredOn;

    public DomainEvent() {
        this.id = UUID.randomUUID();
        this.occuredOn = LocalDateTime.now();
    }
}
