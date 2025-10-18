package bo.nur.sgp_pln.infrastructure.persistence.persistence_model;

import bo.nur.sgp_pln.domain.ingrediente.Ingrediente;
import bo.nur.sgp_pln.domain.receta.RecetaIngrediente;
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
@Table(schema = "public", name = "receta_ingrediente")
public class RecetaIngredienteModel {

    @Id
    @Column(name = "id")
    private UUID id;
    @Column(name = "id_receta")
    private UUID idReceta;
    @Column(name = "id_ingrediente")
    private UUID idIngrediente;
    @Column(name = "cantidad", columnDefinition = "numeric")
    private Integer cantidad;

    public static RecetaIngredienteModel buildModel(UUID idReceta, RecetaIngrediente entity) {
        return RecetaIngredienteModel.builder()
                .id(entity.getId())
                .idReceta(idReceta)
                .idIngrediente(entity.getIdIngrediente())
                .cantidad(entity.getCantidad())
                .build();
    }
}
