package bo.nur.sgp_pln.infrastructure.persistence.persistence_model;

import bo.nur.sgp_pln.domain.plan_alimentario.TiempoComidaReceta;
import bo.nur.sgp_pln.domain.receta.Receta;
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
@Table(schema = "public", name = "tiempo_comida_receta")
public class TiempoComidaRecetaModel {

    @Id
    @Column(name = "id")
    private UUID id;
    @Column(name = "id_tiempo_comida")
    private UUID idTiempoComida;
    @Column(name = "id_receta")
    private UUID idReceta;
    @Column(name = "porcion", columnDefinition = "numeric")
    private Integer porcion;

    public static TiempoComidaRecetaModel buildModel(UUID idTiempoComida, TiempoComidaReceta entity) {
        return TiempoComidaRecetaModel.builder()
                .id(entity.getId())
                .idTiempoComida(idTiempoComida)
                .idReceta(entity.getIdReceta())
                .porcion(entity.getPorcion())
                .build();
    }

}
