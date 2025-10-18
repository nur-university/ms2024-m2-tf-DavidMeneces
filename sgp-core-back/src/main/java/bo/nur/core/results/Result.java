package bo.nur.core.results;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> {
    private Boolean success;
    @Builder.Default
    private LocalDateTime dateTime = LocalDateTime.now();
    private List<String> message;
    private T data;
}
