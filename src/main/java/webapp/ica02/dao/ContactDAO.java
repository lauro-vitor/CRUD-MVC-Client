/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webapp.ica02.dao;

/**
 *
 * @author laurovpina
 */
import java.util.List;
import webapp.ica02.model.Contact;
import javax.persistence.*;

public class ContactDAO implements IDAO<Contact> {

    private final EntityManagerFactory emf;
    private EntityManager em;

    public ContactDAO() {
        emf = Persistence.createEntityManagerFactory("Client_PU");
    }

    @Override
    public void add(Contact o) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(o);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void update(Contact o) {
       em = emf.createEntityManager();
       em.getTransaction().begin();
       em.merge(o);
       em.getTransaction().commit();
       em.close();
    }

    @Override
    public void remove(Contact o) {
       em = emf.createEntityManager();
       em.getTransaction().begin();
       Contact c = em.find(Contact.class, o.getId());
       em.remove(c);
       em.getTransaction().commit();
       em.close();
    }

    @Override
    public Contact getElementById(int id) {
       em = emf.createEntityManager();
       Contact o = em.find(Contact.class,id);
       em.close();
       return o;
    }

    @Override
    public List<Contact> getAllElements() {
       em = emf.createEntityManager();
       Query query = em.createQuery("SELECT c FROM Contact c");
       List<Contact> contacts = (List<Contact>) query.getResultList();
       em.close();
       return contacts;
    }

}
