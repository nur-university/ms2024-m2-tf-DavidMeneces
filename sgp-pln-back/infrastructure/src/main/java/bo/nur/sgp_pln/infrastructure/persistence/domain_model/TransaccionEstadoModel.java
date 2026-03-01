package bo.nur.sgp_pln.infrastructure.persistence.domain_model;

import lombok.Getter;

@Getter
public enum TransaccionEstadoModel {

    CREAR("CREADO"), ELIMINAR("ELIMINADO");
    private final String estado;

    TransaccionEstadoModel(String estado) {
        this.estado = estado;
    }
}
