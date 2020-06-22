/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author laurovpina
 */
import webapp.ica02.model.*;
import webapp.ica02.dao.*;
import java.util.List;
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ContactDAO cdao = new ContactDAO();
        Contact c = new Contact();
        c.setId(1);
        c.setEmail("exemplo@email.com");
        c.setPhone("27 998142395");
        cdao.remove(c);
        System.out.println("removido");
    }
    
}
