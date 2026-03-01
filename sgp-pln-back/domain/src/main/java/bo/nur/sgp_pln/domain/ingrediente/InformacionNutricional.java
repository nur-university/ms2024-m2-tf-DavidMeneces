package bo.nur.sgp_pln.domain.ingrediente;

import bo.nur.core.abstractions.Entity;
import bo.nur.sgp_pln.domain.shared.UnidadMedida;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
public class InformacionNutricional extends Entity {
    private String tipo;
    private UnidadMedida unidadMedida;
    private BigDecimal valor;

    public InformacionNutricional() {
    }

    private InformacionNutricional(UUID id, String tipo, UnidadMedida unidadMedida, BigDecimal valor) {
        super(id);
        this.tipo = tipo;
        this.unidadMedida = unidadMedida;
        this.valor = valor;
    }

    public static InformacionNutricional create(UUID id, String tipo, UnidadMedida unidadMedida, BigDecimal valor) {
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }
        if (unidadMedida == null) {
            throw new IllegalArgumentException("UnidadMedida cannot be null");
        }
        if (valor == null || valor.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("valor cannot be null and minor than zero");
        }
        return new InformacionNutricional(id, tipo, unidadMedida, valor);
    }
}
