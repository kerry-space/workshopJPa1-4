package se.lexicon.workshopjpa14.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.workshopjpa14.Exception.ExceptionHandling;
import se.lexicon.workshopjpa14.dao.DetailsDao;
import se.lexicon.workshopjpa14.entity.AppUser;
import se.lexicon.workshopjpa14.entity.Details;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;
import java.util.Optional;

@Repository
public class DetailsDaoImpl implements DetailsDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public Details findById(int id) {
        if(id == 0)throw new IllegalArgumentException("The id was not found!");
        return entityManager.find(Details.class, id);
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<Details> findAll() {
        return entityManager.createQuery("select d from Details d").getResultList();
    }

    @Override
    @Transactional
    public Details create(Details details) {
        if ( details == null)throw new IllegalArgumentException("Details data was null!");
        entityManager.persist(details);
        return details;
    }

    @Override
    @Transactional
    public Details update(Details details) {
        if (details == null)throw new IllegalArgumentException("The details data was null!");
        entityManager.merge(details);
        return details;
    }

    @Override
    @Transactional
    public void delete(int id) throws ExceptionHandling{
        if(id == 0)throw new IllegalArgumentException("The id was not found!");
        Details details = entityManager.find(Details.class, id);
        if (details == null)throw new ExceptionHandling("The appUser data was not found by the given id");
    }
}
