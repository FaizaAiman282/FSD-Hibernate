package com.example.bookdemo;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class BookDAO {

    private SessionFactory sessionFactory;

    public BookDAO() {
        sessionFactory = Utility.getSessionFactory();
    }

    private Session getSession() {
        return sessionFactory.openSession();
    }

    public void save(Book book) {
        Session session = getSession();
        Transaction tx = session.beginTransaction();

        session.persist(book);

        tx.commit();
        session.close();
    }

    public Book findById(int id) {
        Session session = getSession();

        Book book = session.get(Book.class, id);

        session.close();
        return book;
    }

    public List<Book> findAll() {
        Session session = getSession();

        List<Book> list = session.createQuery("from Book", Book.class).list();

        session.close();
        return list;
    }

    public void update(Book book) {
        Session session = getSession();
        Transaction tx = session.beginTransaction();

        session.merge(book);

        tx.commit();
        session.close();
    }

    public void delete(int id) {
        Session session = getSession();
        Transaction tx = session.beginTransaction();

        Book book = session.get(Book.class, id);

        if (book != null) {
            session.remove(book);
        }

        tx.commit();
        session.close();
    }
}