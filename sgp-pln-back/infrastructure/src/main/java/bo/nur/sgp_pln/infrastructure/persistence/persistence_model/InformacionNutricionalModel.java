package bo.nur.sgp_pln.infrastructure.persistence.persistence_model;

import bo.nur.sgp_pln.domain.ingrediente.InformacionNutricional;
import bo.nur.sgp_pln.infrastructure.persistence.domain_model.TransaccionEstadoModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(schema = "public", name = "informacion_nutricional")
public class InformacionNutricionalModel {

    @Id
    @Column(name = "id")
    private UUID id;
    @Column(name = "id_ingrediente")
    private UUID idIngrediente;
    @Column(name = "tipo")
    private String tipo;
    @Column(name = "unidad_medida")
    private String unidadMedida;
    @Column(name = "valor", columnDefinition = "numeric")
    private BigDecimal valor;
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

    public static InformacionNutricionalModel buildModel(UUID idIngrediente, InformacionNutricional entity) {
        var transaccion = TransaccionEstadoModel.CREAR;
        return InformacionNutricionalModel.builder()
                .id(entity.getId())
                .idIngrediente(idIngrediente)
                .tipo(entity.getTipo())
                .unidadMedida(entity.getUnidadMedida().name())
                .valor(entity.getValor())
                .transaccion(transaccion.name())
                .estado(transaccion.getEstado())
                .usuarioCreacion("sgp-pln")
                .fechaCreacion(LocalDateTime.now())
                .build();
    }
}
