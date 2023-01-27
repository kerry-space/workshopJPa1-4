package se.lexicon.workshopjpa14.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.workshopjpa14.Exception.ExceptionHandling;
import se.lexicon.workshopjpa14.dao.BookLoanDao;
import se.lexicon.workshopjpa14.entity.BookLoan;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;

@Repository
public class BookLoanDaoImpl implements BookLoanDao {

    @PersistenceContext
    EntityManager entityManager;
    @Override
    @Transactional(readOnly = true)
    public BookLoan findById(int id) {
        if(id == 0)throw new IllegalArgumentException("The id was not found!");
        return entityManager.find(BookLoan.class,id);
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<BookLoan> findAll() {
       return entityManager.createQuery("select b from BookLoan b").getResultList();
    }

    @Override
    @Transactional
    public BookLoan create(BookLoan bookLoan) {
        if(bookLoan == null)throw new IllegalArgumentException("The bookLoan data was null!");
         entityManager.persist(bookLoan);
         return bookLoan;
    }

    @Override
    @Transactional
    public BookLoan update(BookLoan bookLoan) {
        if(bookLoan == null)throw new IllegalArgumentException("The bookLoan data was null!");
       return entityManager.merge(bookLoan);
    }

    @Override
    @Transactional
    public void delete(int id) throws ExceptionHandling {
        if (id == 0)throw new IllegalArgumentException("The id was parameter was not found");
       BookLoan bookLoan = entityManager.find(BookLoan.class, id);
       if (bookLoan == null)throw new ExceptionHandling("The bookLoan was not found by the given id!");
       entityManager.remove(bookLoan);
    }
}
