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
import javax.persistence.*;
import webapp.ica02.model.Client;
public class ClientDAO implements IDAO<Client> {
   private final EntityManagerFactory emf;
   private EntityManager em;
   public ClientDAO(){
     emf = Persistence.createEntityManagerFactory("Client_PU");
   }
    @Override
    public void add(Client o) {
       em = emf.createEntityManager();
       em.getTransaction().begin();
       em.persist(o);
       em.getTransaction().commit();
       em.close();
    }

    @Override
    public void update(Client o) {
       em = emf.createEntityManager();
       em.getTransaction().begin();
       em.merge(o);
       em.getTransaction().commit();
       em.close();
    }

    @Override
    public void remove(Client o) {
       em = emf.createEntityManager();
       em.getTransaction().begin();
       Client c = em.find(Client.class, o.getId());
       em.remove(c);
       em.getTransaction().commit();
       em.close();
    }

    @Override
    public Client getElementById(int id) {
       em = emf.createEntityManager();
       Client o = em.find(Client.class,id);
       em.close();
       return o;
    }

    @Override
    public List<Client> getAllElements() {
        em = emf.createEntityManager();
       Query query = em.createQuery("SELECT c FROM Client c");
       List<Client> clients = (List<Client>) query.getResultList();
       em.close();
       return clients;
    }
    
}
