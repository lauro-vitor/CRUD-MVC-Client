/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webapp.ica02.dao;
import javax.persistence.*;
import webapp.ica02.model.State;
import java.util.List;
public class StateDAO {
   private final EntityManagerFactory emf;
   private EntityManager em;
   public StateDAO(){
       emf = Persistence.createEntityManagerFactory("Client_PU");
   }
   public void add(State s){
       em = emf.createEntityManager();
       em.getTransaction().begin();
       em.persist(s);
       em.getTransaction().commit();
       em.close();
   }
   public void update(State s){
       em = emf.createEntityManager();
       em.getTransaction().begin();
       em.merge(s);
       em.getTransaction().commit();
       em.close();
   }
   public void remove(State o){
       em = emf.createEntityManager();
       em.getTransaction().begin();
       State s = em.find(State.class, o.equals(o));
       em.remove(s);
       em.getTransaction().commit();
       em.close();
   }
   public State getElementById(int id){
       em = emf.createEntityManager();
       State s = em.find(State.class,id);
       em.close();
       return s;
   }
   public List<State> getAllElements(){
       em = emf.createEntityManager();
       Query query = em.createQuery("SELECT s FROM State s");
       List<State> states = (List<State>) query.getResultList();
       em.close();
       return states;
   }
}
