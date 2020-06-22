<%-- 
    Document   : cadastro
    Created on : 21/06/2020, 08:04:51
    Author     : laurovpina
--%>

<%@page 
    contentType="text/html" 
    pageEncoding="UTF-8"
    import="webapp.ica02.model.Client"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="node_modules/bootstrap/dist/css/bootstrap.min.css"/>
        <style>
            p{
                color:red;
                visibility: hidden;
            }
        </style>
        <script type="text/javascript" src="node_modules/validator/validator.min.js"></script>
        <script type="text/javascript" src="node_modules/js-brasil/js-brasil.js"></script>
        <script type="text/javascript" src="scripts/validate-form.js"></script>
        <% 
            String idClient = "0";
            String idAddress = "0";
            String idContact = "0";
            String action = "ADD";
            String firstName = "";
            String lastName = "";
            String cpf = "";
            String postalCode = "";
            String city = "";
            String addressName = "";
            String email = "";
            String phone = "";
            Client c = new Client();
            if(request.getAttribute("clientToUpdate")!= null) {
              c = (Client)request.getAttribute("clientToUpdate");
              action =  "UPDATE";
              idClient = Integer.toString(c.getId());
              idContact = Integer.toString(c.getContact().getId());
              idAddress = Integer.toString(c.getAddress().getId());
              firstName = c.getFirstName();
              lastName = c.getLastName();
              cpf = c.getCpf();
              postalCode = c.getAddress().getPostalCode();
              city = c.getAddress().getCity();
              addressName = c.getAddress().getAddessName();
              email = c.getContact().getEmail();
              phone = c.getContact().getPhone();
            }
           
        %>
    </head>
    <body class="container">
        <h1>Cadastro de Cliente</h1>
        <form  method="POST" action="controller" onsubmit="return validateForm()">
            <input type="hidden" name="idClient" value="<%=idClient%>" />
            <input type="hidden" name="idAddress" value="<%=idAddress%>" />
            <input type="hidden" name="idContact" value="<%=idContact%>" />
            <input type="hidden" name="action" value="<%=action%>" />
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="nome">Nome:</label>
                    <input 
                        type="text" 
                        class="form-control" 
                        id="firstNameId" 
                        name="firstNameName"
                        value="<%=firstName%>"/>
                    <p id="errorfirstName">Mensagem</p>
                </div>
                <div class="form-group col-md-6">
                    <label for="nome">Sobrenome:</label>
                    <input 
                        type="text" 
                        class="form-control" 
                        id="lastNameId" 
                        name="lastNameName"
                        value="<%=lastName%>"/>
                     <p id="errorLastName">Mensagem</p>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-12">
                    <label for="cpf">CPF:</label>
                    <input
                        type="text"
                        class="form-control"
                        id="cpfId"
                        name="cpfName"
                        value="<%=cpf%>"
                        placeholder="xxx.xxx.xxx-xx"/>
                     <p id="errorCpf">Mensagem</p>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-2">
                    <label for="cep">CEP:</label>
                    <input 
                        type="text"
                        class="form-control"
                        id="postalCodeId"
                        name="postalCodeName"
                        value="<%=postalCode%>"
                        placeholder="xxxxx-xxx"/>
                     <p id="errorCep">Mensagem</p>
                </div>
                <div class="form-group col-md-4">
                    <label for="estado">Estado:</label>
                    <select id="statesId" name="statesName" class="form-control">
                        <option value="1">ES</option>
                        <option value="2">MG</option>
                        <option value="3">RJ</option>
                        <option value="4">SP</option>
                    </select>
                </div>
                <div class="form-group col-md-6">
                    <label for="bairro">Cidade:</label>
                    <input 
                        class="form-control"
                        type="text"
                        name="cityName"
                        id="cityId"
                        value="<%=city%>"
                        />
                     <p id="errorCity">Mensagem</p>
                </div>
            </div>
            <div class="form-group">
                    <label for="endereço">Endereço:</label>
                    <input
                        class="form-control"
                        type="text"
                        name="addressName"
                        id="addressId"
                        value="<%=addressName%>"/>
                     <p id="errorAddress">Mensagem</p>
            </div>
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label>Email:</label>
                    <input 
                        type="text"
                        class="form-control"
                        name="emailName"
                        id="emailId"
                        value="<%=email%>"
                        placeholder="exemplo@email.com"/>
                     <p id="errorEmail">Mensagem</p>
                </div>
                 <div class="form-group col-md-6">
                    <label>Telefone:</label>
                    <input 
                        type="text"
                        class="form-control"
                        name="phoneName"
                        id="phoneId"
                        value="<%=phone%>"
                        placeholder="(99) 99999-9999"/>
                     <p id="errorPhone">Mensagem</p>
                </div>
            </div>
            <div class="form-group" style="text-align: end">
                <input 
                type="submit" 
                value="salvar" 
                class="btn btn-primary btn-lg"
                />
            </div>
            
        </form>
    </body>
</html>
