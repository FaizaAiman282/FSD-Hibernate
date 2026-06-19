package col.example.productdemo;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class ProductDAO {

    private SessionFactory sessionFactory;

    public ProductDAO() {
        sessionFactory = Utility.getSessionFactory();
    }

    private Session getSession() {
        return sessionFactory.openSession();
    }

    // CREATE
    public void save(Product p) {
        Session session = getSession();
        Transaction tx = session.beginTransaction();

        session.persist(p);

        tx.commit();
        session.close();
    }

    // READ BY ID
    public Product findById(int id) {
        Session session = getSession();

        Product p = session.find(Product.class, id);

        session.close();
        return p;
    }

    // READ ALL
    public List<Product> findAll() {
        Session session = getSession();

        List<Product> products = session
                .createQuery("from Product", Product.class)
                .list();

        session.close();
        return products;
    }

    // UPDATE
    public void update(Product p) {
        Session session = getSession();
        Transaction tx = session.beginTransaction();

        session.merge(p);

        tx.commit();
        session.close();
    }

    // DELETE
    public void delete(int id) {
        Session session = getSession();
        Transaction tx = session.beginTransaction();

        Product p = session.find(Product.class, id);

        if (p != null) {
            session.remove(p);
        }

        tx.commit();
        session.close();
    }
}