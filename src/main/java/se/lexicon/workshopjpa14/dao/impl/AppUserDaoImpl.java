package se.lexicon.workshopjpa14.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.workshopjpa14.Exception.ExceptionHandling;
import se.lexicon.workshopjpa14.dao.AppUserDao;
import se.lexicon.workshopjpa14.entity.AppUser;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;
import java.util.Optional;

@Repository
public class AppUserDaoImpl implements AppUserDao {

    @PersistenceContext
    EntityManager entityManager;


    @Override
    @Transactional(readOnly = true)
    public AppUser findById(int id) {
        if(id == 0)throw new IllegalArgumentException("The id was not found!");
        return entityManager.find(AppUser.class, id);
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<AppUser> findAll() {
        return entityManager.createQuery("select a from AppUser a").getResultList();
    }

    @Override
    @Transactional
    public AppUser create(AppUser appUser) {
        if (appUser == null)throw new IllegalArgumentException("Appuser data was null!");
        entityManager.persist(appUser);
        return appUser;
    }

    @Override
    @Transactional
    public AppUser update(AppUser appUser) {
        if (appUser == null)throw new IllegalArgumentException("The appUser data was null!");
        entityManager.merge(appUser);
        return appUser;
    }

    @Override
    @Transactional
    public void delete(int id) throws ExceptionHandling{
        if(id == 0)throw new IllegalArgumentException("The id was not found!");
        AppUser appUser = entityManager.find(AppUser.class, id);
        if (appUser == null)throw new ExceptionHandling("The appUser data was not found by the given id");

    }
}
