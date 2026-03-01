package bo.nur.sgp_pln.infrastructure.persistence.persistence_model;

import bo.nur.sgp_pln.domain.ingrediente.Ingrediente;
import bo.nur.sgp_pln.domain.receta.Receta;
import bo.nur.sgp_pln.domain.receta.RecetaIngrediente;
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
@Table(schema = "public", name = "receta")
public class RecetaModel {

    @Id
    @Column(name = "id")
    private UUID id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "instrucciones")
    private String instrucciones;
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

    public static RecetaModel buildModel(Receta entity) {
        var transaccion = TransaccionEstadoModel.CREAR;
        return RecetaModel.builder()
                .id(entity.getId())
                .nombre(entity.getNombre())
                .descripcion(entity.getDescripcion())
                .instrucciones(entity.getInstrucciones())
                .transaccion(transaccion.name())
                .estado(transaccion.getEstado())
                .usuarioCreacion("sgp-pln")
                .fechaCreacion(LocalDateTime.now())
                .build();
    }
}
