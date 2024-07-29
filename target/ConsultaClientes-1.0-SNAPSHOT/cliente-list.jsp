<%-- 
    Document   : cliente-list
    Created on : 27/07/2024, 7:23:52 p. m.
    Author     : gcardenas
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Lista de Clientes</title>
        <link rel="stylesheet" href="css/styles.css">    
        <link rel="stylesheet" href="css/bootstrap/bootstrap.min.css">
    </head>
    <body>
        <section class="p-3 p-md-4 p-xl-5">
            <div class="container">
                <div class="row">
                    <div class="card sombra col-md-12 p-5 table-responsive">
                        <div class="card col-md-6 mx-auto text-center mb-5 sombra">
                            <h1 class="text-center">Clientes</h1>
                        </div>                        
                        <table class="table table-striped table-bordered col-md-12 text-center">
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Identificación</th>                                        
                                    <th>Nombres</th>
                                    <th>Apellidos</th>
                                    <th>Acciones</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="cliente" items="${listaClientes}">
                                    <tr>
                                        <td>${cliente.id_Cliente}</td>                                            
                                        <td>${cliente.identificacion}</td>                                            
                                        <td>${cliente.nombre1} ${cliente.nombre_2}</td>
                                        <td>${cliente.apellido_1} ${cliente.apellido_2}</td>
                                        <td>
                                            <a type="button" class="btn btn-outline-warning" href="ClienteServlet?action=edit&id=${cliente.id_Cliente}">Ver</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>                   
                    </div>
                </div>
            </div>
        </section>
    </body>
</html>