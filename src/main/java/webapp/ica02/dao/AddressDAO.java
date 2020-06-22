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
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import webapp.ica02.model.Address;
public class AddressDAO implements IDAO<Address>{
    private final EntityManagerFactory emf;
    private EntityManager em;

    public AddressDAO() {
        emf = Persistence.createEntityManagerFactory("Client_PU");
    }
    @Override
    public void add(Address o) {
          em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(o);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void update(Address o) {
       em = emf.createEntityManager();
       em.getTransaction().begin();
       em.merge(o);
       em.getTransaction().commit();
       em.close();
    }

    @Override
    public void remove(Address o) {
       em = emf.createEntityManager();
       em.getTransaction().begin();
       Address a = em.find(Address.class, o.getId());
       em.remove(a);
       em.getTransaction().commit();
       em.close();
    }

    @Override
    public Address getElementById(int id) {
         em = emf.createEntityManager();
       Address o = em.find(Address.class,id);
       em.close();
       return o;
    }

    @Override
    public List<Address> getAllElements() {
        em = emf.createEntityManager();
       Query query = em.createQuery("SELECT a FROM Address a");
       List<Address> address = (List<Address>) query.getResultList();
       em.close();
       return address;
    }
    
}
