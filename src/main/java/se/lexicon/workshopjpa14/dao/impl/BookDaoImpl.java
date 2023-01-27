package se.lexicon.workshopjpa14.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.workshopjpa14.Exception.ExceptionHandling;
import se.lexicon.workshopjpa14.dao.BookDao;
import se.lexicon.workshopjpa14.entity.Book;
import se.lexicon.workshopjpa14.entity.BookLoan;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;

@Repository
public class BookDaoImpl implements BookDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public Book findById(int id) {
        if(id == 0)throw new IllegalArgumentException("The id was not found!");
        return entityManager.find(Book.class,id);
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<Book> findAll() {
        return entityManager.createQuery("select b from Book b").getResultList();

    }

    @Override
    @Transactional
    public Book create(Book book) {
        if(book == null)throw new IllegalArgumentException("The bookLoan data was null!");
        entityManager.persist(book);
        return book;
    }

    @Override
    @Transactional
    public Book update(Book book) {
        if(book == null)throw new IllegalArgumentException("The bookLoan data was null!");
        return entityManager.merge(book);
    }

    @Override
    @Transactional
    public void delete(int id) throws ExceptionHandling {
        if (id == 0)throw new IllegalArgumentException("The id was parameter was not found");
        Book book = entityManager.find(Book.class, id);
        if (book == null)throw new ExceptionHandling("The book was not found by the given id!");
        entityManager.remove(book);

    }
}
