package bo.nur.sgp_pln.domain.plan_alimentario;

import bo.nur.core.abstractions.Entity;
import bo.nur.sgp_pln.domain.shared.TipoTiempoComida;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter
public class TiempoComida extends Entity {
    private TipoTiempoComida tipo;
    private Integer orden;
    private List<TiempoComidaReceta> recetas;

    public TiempoComida() {
        super();
    }

    private TiempoComida(UUID id, TipoTiempoComida tipo, Integer orden, List<TiempoComidaReceta> recetas) {
        super(id);
        this.tipo = tipo;
        this.orden = orden;
        this.recetas = recetas;
    }

    public static TiempoComida create(UUID id, TipoTiempoComida tipo, Integer orden, List<TiempoComidaReceta> recetas) {
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }
        if (tipo == null) {
            throw new IllegalArgumentException("tipo cannot be null");
        }
        if (orden == null || orden <= 0) {
            throw new IllegalArgumentException("orden cannot be null or minor equal zero");
        }
        if (recetas == null || recetas.isEmpty()) {
            throw new IllegalArgumentException("recetas cannot be null or empty");
        }
        return new TiempoComida(id, tipo, orden, recetas);
    }

}
