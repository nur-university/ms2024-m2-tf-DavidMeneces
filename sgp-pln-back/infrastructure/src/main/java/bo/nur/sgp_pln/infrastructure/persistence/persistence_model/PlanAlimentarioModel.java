package bo.nur.sgp_pln.infrastructure.persistence.persistence_model;

import bo.nur.sgp_pln.domain.plan_alimentario.PlanAlimentario;
import bo.nur.sgp_pln.domain.plan_alimentario.PlanAlimentarioDia;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(schema = "public", name = "plan_alimentario")
public class PlanAlimentarioModel {
    @Id
    @Column(name = "id")
    private UUID id;
    @Column(name = "dias")
    private Integer dias;

    public static PlanAlimentarioModel buildModel(PlanAlimentario entity) {
        return PlanAlimentarioModel.builder()
                .id(entity.getId())
                .dias(entity.getDias())
                .build();
    }
}
