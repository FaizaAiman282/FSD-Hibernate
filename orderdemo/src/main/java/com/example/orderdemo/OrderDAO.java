package com.example.orderdemo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class OrderDAO {

    private SessionFactory sessionFactory;

    public OrderDAO() {
        sessionFactory = Utility.getSessionFactory();
    }

    private Session getSession() {
        return sessionFactory.openSession();
    }

    // CREATE
    public void save(Orders order) {
        Session session = getSession();
        Transaction tx = session.beginTransaction();

        session.persist(order);

        tx.commit();
        session.close();
    }

    // READ BY ID
    public Orders findById(int id) {
        Session session = getSession();

        Orders order = session.find(Orders.class, id);

        session.close();
        return order;
    }

    // READ ALL
    public List<Orders> findAll() {
        Session session = getSession();

        List<Orders> list =
                session.createQuery("from Orders", Orders.class)
                        .list();

        session.close();
        return list;
    }

    // UPDATE
    public void update(Orders order) {
        Session session = getSession();
        Transaction tx = session.beginTransaction();

        session.merge(order);

        tx.commit();
        session.close();
    }

    // DELETE
    public void delete(int id) {
        Session session = getSession();
        Transaction tx = session.beginTransaction();

        Orders order = session.find(Orders.class, id);

        if (order != null) {
            session.remove(order);
        }

        tx.commit();
        session.close();
    }
}