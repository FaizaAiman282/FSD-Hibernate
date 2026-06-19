package com.example.studentdemo;



import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class StudentDAO {

    private SessionFactory sessionFactory;

    public StudentDAO() {
        sessionFactory = Utility.getSessionFactory();
    }

    private Session getSession() {
        return sessionFactory.openSession();
    }

    // CREATE
    public void save(Student student) {

        Session session = getSession();
        Transaction tx = session.beginTransaction();

        session.persist(student);

        tx.commit();
        session.close();
    }

    // READ BY ID
    public Student findById(int id) {

        Session session = getSession();

        Student student = session.find(Student.class, id);

        session.close();

        return student;
    }

    // READ ALL
    public List<Student> findAll() {

        Session session = getSession();

        List<Student> students =
                session.createQuery("from Student", Student.class)
                       .list();

        session.close();

        return students;
    }

    // UPDATE
    public void update(Student student) {

        Session session = getSession();
        Transaction tx = session.beginTransaction();

        session.merge(student);

        tx.commit();
        session.close();
    }

    // DELETE
    public void delete(int id) {

        Session session = getSession();
        Transaction tx = session.beginTransaction();

        Student student = session.find(Student.class, id);

        if (student != null) {
            session.remove(student);
        }

        tx.commit();
        session.close();
    }
}