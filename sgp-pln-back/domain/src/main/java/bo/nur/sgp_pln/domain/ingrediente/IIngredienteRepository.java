package bo.nur.sgp_pln.domain.ingrediente;

import bo.nur.core.abstractions.IRepository;
import jakarta.enterprise.inject.Default;

import java.util.UUID;

@Default
public interface IIngredienteRepository extends IRepository<Ingrediente> {
    void updateAsync(Ingrediente item);

    void deleteAsync(UUID id);
}
