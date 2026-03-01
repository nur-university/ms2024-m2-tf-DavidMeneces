package bo.nur.sgp_pln.infrastructure.persistence.repositories;

import bo.nur.sgp_pln.domain.receta.IRecetaRepository;
import bo.nur.sgp_pln.domain.receta.Receta;
import bo.nur.sgp_pln.infrastructure.persistence.persistence_model.RecetaIngredienteModel;
import bo.nur.sgp_pln.infrastructure.persistence.persistence_model.RecetaModel;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

import java.util.UUID;

@ApplicationScoped
public class RecetaRepository implements IRecetaRepository {

    @Inject
    EntityManager manager;

    @Override
    public Receta getById(UUID id) {
        return null;
    }

    @Override
    public Receta getById(UUID id, boolean readOnly) {
        return null;
    }

    @Override
    public void insert(Receta entity) {
        var recetaModel = RecetaModel.buildModel(entity);
        manager.persist(recetaModel);
        manager.flush();
        for (var recetaIngrediente : entity.getIngredientes()) {
            var recetaIngredienteModel = RecetaIngredienteModel.buildModel(entity.getId(), recetaIngrediente);
            manager.persist(recetaIngredienteModel);
        }
        manager.flush();
    }

    @Override
    public void update(Receta item) {

    }

    @Override
    public void delete(UUID id) {

    }
}
