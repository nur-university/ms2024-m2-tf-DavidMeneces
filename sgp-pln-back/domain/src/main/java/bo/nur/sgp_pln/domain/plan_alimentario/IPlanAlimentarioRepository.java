package bo.nur.sgp_pln.domain.plan_alimentario;

import bo.nur.core.abstractions.IRepository;
import jakarta.enterprise.inject.Default;

import java.util.UUID;

@Default
public interface IPlanAlimentarioRepository extends IRepository<PlanAlimentario> {
    void update(PlanAlimentario item);

    void delete(UUID id);
}
