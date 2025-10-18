package bo.nur.sgp_pln.infrastructure.persistence.repositories;

import bo.nur.sgp_pln.domain.plan_alimentario.IPlanAlimentarioRepository;
import bo.nur.sgp_pln.domain.plan_alimentario.PlanAlimentario;
import bo.nur.sgp_pln.infrastructure.persistence.persistence_model.*;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

import java.util.UUID;

@ApplicationScoped
public class PlanAlimentarioRepository implements IPlanAlimentarioRepository {

    @Inject
    EntityManager manager;

    @Override
    public PlanAlimentario getById(UUID id) {
        return null;
    }

    @Override
    public PlanAlimentario getById(UUID id, boolean readOnly) {
        return null;
    }

    @Override
    @Transactional
    public void insert(PlanAlimentario entity) {
        var planAlimentario = PlanAlimentarioModel.buildModel(entity);
        manager.persist(planAlimentario);
        manager.flush();
        for (var planAlimentarioDia : entity.getPlanAlimentarioDias()) {
            var planAlimentarioDiaModel = PlanAlimentarioDiaModel.buildModel(planAlimentario.getId(), planAlimentarioDia);
            manager.persist(planAlimentarioDiaModel);
            manager.flush();
            for (var tiempoComida : planAlimentarioDia.getTiempoComidas()){
                var tiempoComidaModel = TiempoComidaModel.buildModel(planAlimentarioDiaModel.getId(), tiempoComida);
                manager.persist(tiempoComidaModel);
                manager.flush();
                for (var tiempoComidaReceta : tiempoComida.getRecetas()){
                    var tiempoComidaRecetaModel = TiempoComidaRecetaModel.buildModel(tiempoComidaModel.getId(), tiempoComidaReceta);
                    manager.persist(tiempoComidaRecetaModel);
                    manager.flush();
                }
            }
        }
        manager.flush();
    }

    @Override
    public void update(PlanAlimentario item) {

    }

    @Override
    public void delete(UUID id) {

    }
}
