package bo.nur.sgp_pln.infrastructure.persistence.persistence_model;

import bo.nur.sgp_pln.domain.plan_alimentario.TiempoComida;
import bo.nur.sgp_pln.domain.plan_alimentario.TiempoComidaReceta;
import bo.nur.sgp_pln.domain.shared.TipoTiempoComida;
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
@Table(schema = "public", name = "tiempo_comida")
public class TiempoComidaModel {

    @Id
    @Column(name = "id")
    private UUID id;
    @Column(name = "id_plan_alimentario_dia")
    private UUID idPlanAlimentarioDia;
    @Column(name = "tipo")
    private String tipo;
    @Column(name = "orden", columnDefinition = "numeric")
    private Integer orden;

    public static TiempoComidaModel buildModel(UUID idPlanAlimentarioDia, TiempoComida entity) {
        return TiempoComidaModel.builder()
                .id(entity.getId())
                .idPlanAlimentarioDia(idPlanAlimentarioDia)
                .tipo(entity.getTipo().name())
                .orden(entity.getOrden())
                .build();
    }
}
