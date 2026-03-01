package bo.nur.sgp_pln.infrastructure.persistence.persistence_model;

import bo.nur.sgp_pln.domain.plan_alimentario.PlanAlimentario;
import bo.nur.sgp_pln.domain.plan_alimentario.PlanAlimentarioDia;
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
@Table(schema = "public", name = "plan_alimentario")
public class PlanAlimentarioModel {
    @Id
    @Column(name = "id")
    private UUID id;
    @Column(name = "dias")
    private Integer dias;
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

    public static PlanAlimentarioModel buildModel(PlanAlimentario entity) {
        var transaccion = TransaccionEstadoModel.CREAR;
        return PlanAlimentarioModel.builder()
                .id(entity.getId())
                .dias(entity.getDias())
                .transaccion(transaccion.name())
                .estado(transaccion.getEstado())
                .usuarioCreacion("sgp-pln")
                .fechaCreacion(LocalDateTime.now())
                .build();
    }
}
