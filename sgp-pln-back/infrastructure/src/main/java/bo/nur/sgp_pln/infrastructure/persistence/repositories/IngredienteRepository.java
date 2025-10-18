package bo.nur.sgp_pln.infrastructure.persistence.repositories;

import bo.nur.sgp_pln.domain.ingrediente.IIngredienteRepository;
import bo.nur.sgp_pln.domain.ingrediente.Ingrediente;
import bo.nur.sgp_pln.infrastructure.persistence.persistence_model.InformacionNutricionalModel;
import bo.nur.sgp_pln.infrastructure.persistence.persistence_model.IngredienteModel;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

import java.util.UUID;

@ApplicationScoped
public class IngredienteRepository implements IIngredienteRepository {

    @Inject
    EntityManager manager;


    @Override
    public Ingrediente getById(UUID id) {
        return null;
    }

    @Override
    public Ingrediente getById(UUID id, boolean readOnly) {
        return null;
    }

    @Override
    public void insert(Ingrediente entity) {
        var ingredienteModel = IngredienteModel.buildModel(entity);
        manager.persist(ingredienteModel);
        manager.flush();
        for (var infomacionNutricional : entity.getInformacionNutricional()) {
            var infomacionNutricionalModel = InformacionNutricionalModel.buildModel(entity.getId(), infomacionNutricional);
            manager.persist(infomacionNutricionalModel);
        }
        manager.flush();
    }

    @Override
    public void updateAsync(Ingrediente item) {
    }

    @Override
    public void deleteAsync(UUID id) {
    }
}
