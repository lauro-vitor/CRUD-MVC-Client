<%-- 
    Document   : listar
    Created on : 21/06/2020, 19:57:09
    Author     : laurovpina
--%>

<%@page 
    contentType="text/html" 
    pageEncoding="UTF-8" 
    import="webapp.ica02.dao.ClientDAO, webapp.ica02.model.Client, java.util.List"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="node_modules/bootstrap/dist/css/bootstrap.min.css"/>
        <title>JSP Page</title>
        <%
           List<Client> clients = new ClientDAO().getAllElements();
            if(request.getParameter("deleted") != null) {
         %>
         <script>
             alert('contato excluído com sucesso');
         </script>
         <%}%>
    </head>
    <body>
       
        <table class="table">
            <thead>
                <tr>
                    <th scope="col">id</th>
                    <th scope="col">Nome</th>
                    <th scope="col">cpf</th>
                    <th scope="col">Telefone</th>
                    <th scope="col">Email</th>
                    <th scope="col">Endereço</th>
                    <th scope="col">CEP</th>
                    <th scope="col">Cidade</th>
                    <th scope="col">UF</th>
                    <th scope="col">Alterar</th>
                    <th scope="col">Excluir</th>
                </tr>
            </thead>
            <tbody >
            <%
            if(clients != null) {
                for(Client c: clients) {
            %>
            <tr class="table table-striped">
                <th><%=c.getId()%></th>
                <td><%=c.getFirstName()+ " " +c.getLastName()%></td>
                <td><%=c.getCpf()%></td>
                <td><%=c.getContact().getPhone()%></td>
                <td><%=c.getContact().getEmail()%></td>
                <td><%=c.getAddress().getAddessName()%></td>
                <td><%=c.getAddress().getPostalCode()%></td>
                <td><%=c.getAddress().getCity()%></td>
                <td><%=c.getAddress().getState().getUf()%></td>
                <td>
                    <a 
                        href="controller?action=PREPARE_UPDATE&id=<%=c.getId()%>"
                        class="btn btn-warning">
                        alterar
                    </a>
                </td>
                <td>
                    <a 
                        href="controller?action=DELETE&id=<%=c.getId()%>"
                        class="btn btn-danger">
                        excluir
                    </a>
                </td>
            </tr>
            <%  } 
              } %>
            </tbody>
        </table>
    </body>
</html>
