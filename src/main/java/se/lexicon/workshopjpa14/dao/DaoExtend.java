package se.lexicon.workshopjpa14.dao;

import se.lexicon.workshopjpa14.Exception.ExceptionHandling;

import java.util.Collection;

public interface DaoExtend <T>{
    T findById(int id);
    Collection<T> findAll();
    T create(T object);
    T update(T object);
    void delete(int id) throws ExceptionHandling;
}
