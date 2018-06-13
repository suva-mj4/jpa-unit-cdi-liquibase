package ch.suva.extranet.m2mbetriebe.leistungsfall.persistence.repositories;

import ch.suva.extranet.m2mbetriebe.leistungsfall.persistence.entities.stories.IncapacitiesToWork;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@RequestScoped
public class IncapacitiesToWorkRepository {

    private EntityManager entityManager;

    @PersistenceContext(unitName = "unittest")
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<IncapacitiesToWork> getAll() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<IncapacitiesToWork> cq = cb.createQuery(IncapacitiesToWork.class);
        Root<IncapacitiesToWork> root = cq.from(IncapacitiesToWork.class);
        return entityManager.createQuery(cq).getResultList();
    }
}
