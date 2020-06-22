/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webapp.ica02.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import webapp.ica02.model.*;
import webapp.ica02.dao.*;
@WebServlet(name = "ClientServlet", urlPatterns = {"/controller"})
public class ClientServlet extends HttpServlet {
    private Client client = new Client();
    private Address address = new Address();
    private Contact contact = new Contact();
    private State state = new State();
    private String page = "index.html";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        switch(action){
            case "ADD":{
                InstanceObject(request);
                this.addObjects();
                page = "listar.jsp";
                break;
            }
            case "PREPARE_UPDATE":{
                int id  = Integer.parseInt(request.getParameter("id"));
                Client clientToUpdate = new ClientDAO().getElementById(id);
                request.setAttribute("clientToUpdate", clientToUpdate);
                page="cadastro.jsp";
                break;
            }
            case "UPDATE":{
                InstanceObject(request);
                updateObjects();
                page = "listar.jsp";
                break;
            }
            case "DELETE":{
                int id  = Integer.parseInt(request.getParameter("id"));
                Client clientToDelete = new ClientDAO().getElementById(id);
                new ClientDAO().remove(clientToDelete);
                page="listar.jsp?deleted=true";
                break;
            }
            case "LIST":{
                page = "listar.jsp";
                break;
            }
        }
       RequestDispatcher dispatch = request.getRequestDispatcher(this.page);
       dispatch.forward(request, response);
    }
    private void addObjects(){
        new AddressDAO().add(address);
        new ContactDAO().add(contact);
        new ClientDAO().add(client);
    }
    private void updateObjects(){
       new AddressDAO().update(address);
        new ContactDAO().update(contact);
        new ClientDAO().update(client);
    }
    private void InstanceObject(HttpServletRequest req){
        this.setState(req);
        this.setContact(req);
        this.setAddress(req);
        this.setClient(req);
    }
    private void setClient(HttpServletRequest req){
        client.setId(Integer.parseInt(req.getParameter("idClient")));
        client.setFirstName(req.getParameter("firstNameName"));
        client.setLastName(req.getParameter("lastNameName"));
        client.setCpf(req.getParameter("cpfName"));
        client.setAddress(address);
        client.setContact(contact);
    }
    private void setAddress(HttpServletRequest req){
        address.setId(Integer.parseInt(req.getParameter("idAddress")));
        address.setAddessName(req.getParameter("addressName"));
        address.setCity(req.getParameter("cityName"));
        address.setPostalCode(req.getParameter("postalCodeName"));
        address.setState(state);
    }
    private void setContact(HttpServletRequest req){
        contact.setId(Integer.parseInt(req.getParameter("idContact")));
        contact.setEmail(req.getParameter("emailName"));
        contact.setPhone(req.getParameter("phoneName"));
    }
    private void setState(HttpServletRequest req){
        State s = new StateDAO().getElementById(Integer.parseInt(req.getParameter("statesName")));
        if(s != null){
            state = s;
        } else{
            new StateDAO().add(s);
            state = s;
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
