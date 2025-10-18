package bo.nur.sgp_pln.infrastructure.persistence.persistence_model;

import bo.nur.sgp_pln.domain.plan_alimentario.PlanAlimentarioDia;
import bo.nur.sgp_pln.domain.plan_alimentario.TiempoComida;
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
@Table(schema = "public", name = "plan_alimentario_dia")
public class PlanAlimentarioDiaModel {
    @Id
    @Column(name = "id")
    private UUID id;
    @Column(name = "id_plan_alimentario")
    private UUID idPlanAlimentario;
    @Column(name = "dia")
    private Integer dia;

    public static PlanAlimentarioDiaModel buildModel(UUID idPlanAlimentario, PlanAlimentarioDia entity) {
        return PlanAlimentarioDiaModel.builder()
                .id(entity.getId())
                .idPlanAlimentario(idPlanAlimentario)
                .dia(entity.getDia())
                .build();
    }
}
