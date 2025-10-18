package bo.nur.sgp_pln.infrastructure.persistence.repositories;

import bo.nur.core.results.DomainException;
import bo.nur.sgp_pln.domain.ingrediente.IIngredienteRepository;
import bo.nur.sgp_pln.domain.ingrediente.InformacionNutricional;
import bo.nur.sgp_pln.domain.ingrediente.Ingrediente;
import bo.nur.sgp_pln.domain.shared.UnidadMedida;
import bo.nur.sgp_pln.infrastructure.persistence.InfraestructureException;
import bo.nur.sgp_pln.infrastructure.persistence.domain_model.TransaccionEstadoModel;
import bo.nur.sgp_pln.infrastructure.persistence.persistence_model.InformacionNutricionalModel;
import bo.nur.sgp_pln.infrastructure.persistence.persistence_model.IngredienteModel;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class IngredienteRepository implements IIngredienteRepository {

    @Inject
    EntityManager manager;

    @Override
    public Ingrediente getById(UUID id) {
        String jpql = "SELECT i FROM IngredienteModel i WHERE i.id = :id";
        TypedQuery<IngredienteModel> query = manager.createQuery(jpql, IngredienteModel.class);
        query.setParameter("id", id);
        var result = query.getResultList();
        if (!result.isEmpty()) {
            var model = result.get(0);
            if(model.getEstado().equals(TransaccionEstadoModel.ELIMINAR.getEstado())){
                throw new InfraestructureException("Ingrediente eliminado");
            }
            var ingrediente = Ingrediente.create(model.getId(), model.getNombre(), model.getDescripcion(),
                    model.getTipo(), getAllInfNutByIdIngrediente(id));
            return ingrediente;
        }
        throw new InfraestructureException("No existe ningun ingrediente con ese id");
    }

    protected List<InformacionNutricional> getAllInfNutByIdIngrediente(UUID idIngrediente) {
        String jpql = "SELECT i FROM InformacionNutricionalModel i WHERE i.idIngrediente = :idIngrediente";
        TypedQuery<InformacionNutricionalModel> query = manager.createQuery(jpql, InformacionNutricionalModel.class);
        query.setParameter("idIngrediente", idIngrediente);
        var result = query.getResultList();
        return result.stream().map(model -> InformacionNutricional.create(model.getId(), model.getTipo(),
                UnidadMedida.valueOf(model.getUnidadMedida()), model.getValor())).toList();
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
    public void update(Ingrediente item) {
    }

    @Override
    public void delete(UUID id) {
    }
}
