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
public interface IDAO<Obj> {
    public void add(Obj o);
    public void update(Obj o);
    public void remove(Obj o);
    public Obj getElementById(int id);
    public List<Obj> getAllElements();
}
