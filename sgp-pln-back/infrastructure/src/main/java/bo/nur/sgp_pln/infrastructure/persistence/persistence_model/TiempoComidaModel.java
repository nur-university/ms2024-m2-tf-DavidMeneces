package bo.nur.sgp_pln.infrastructure.persistence.persistence_model;

import bo.nur.sgp_pln.domain.plan_alimentario.TiempoComida;
import bo.nur.sgp_pln.domain.plan_alimentario.TiempoComidaReceta;
import bo.nur.sgp_pln.domain.shared.TipoTiempoComida;
import bo.nur.sgp_pln.infrastructure.persistence.domain_model.TransaccionEstadoModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
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
    //Columnas de control de estado entidad
    @Column(name = "transaccion")
    private String transaccion;
    @Column(name = "estado")
    private String estado;
    @Column(name = "usuario_creacion")
    private String usuarioCreacion;
    @Column(name = "fecha_creacion", columnDefinition = "timestamp")
    private LocalDateTime fechaCreacion;
    @Column(name = "usuario_modificacion")
    private String usuarioModificacion;
    @Column(name = "fecha_modificacion", columnDefinition = "timestamp")
    private LocalDateTime fechaModificacion;

    public static TiempoComidaModel buildModel(UUID idPlanAlimentarioDia, TiempoComida entity) {
        var transaccion = TransaccionEstadoModel.CREAR;
        return TiempoComidaModel.builder()
                .id(entity.getId())
                .idPlanAlimentarioDia(idPlanAlimentarioDia)
                .tipo(entity.getTipo().name())
                .orden(entity.getOrden())
                .transaccion(transaccion.name())
                .estado(transaccion.getEstado())
                .usuarioCreacion("sgp-pln")
                .fechaCreacion(LocalDateTime.now())
                .build();
    }
}
