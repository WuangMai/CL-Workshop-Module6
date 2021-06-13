package com.github.WuangMai.workshop.Dao;

import com.github.WuangMai.workshop.model.Book;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class BookDao {

    @PersistenceContext
    protected EntityManager em;

    public Book update(Book book) {
        return em.merge(book);
    }

    public void remove(Book book) {
        em.remove(em.contains(book) ? book : em.merge(book));
    }

    public void add(Book book){
        em.persist(book);
    }
}
