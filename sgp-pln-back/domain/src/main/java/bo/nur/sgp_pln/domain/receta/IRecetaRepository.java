package bo.nur.sgp_pln.domain.receta;

import bo.nur.core.abstractions.IRepository;
import jakarta.enterprise.inject.Default;

import java.util.UUID;

public interface IRecetaRepository extends IRepository<Receta> {
    void update(Receta item);

    void delete(UUID id);
}
