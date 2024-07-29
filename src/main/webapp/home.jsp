<%-- 
    Document   : home
    Created on : 28/07/2024, 5:54:01 p. m.
    Author     : srcharcas
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
        <link rel="stylesheet" href="css/styles.css">    
        <link rel="stylesheet" href="css/bootstrap/bootstrap.min.css">    
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="card mb-3 col-md-6 p-3 p-md-4 p-xl-5 mt-4 sombra">
                    <div class="row g-0">
                        <div class="col-md-4">
                            <img src="images/login.png" class="img-fluid rounded-start" alt="...">
                        </div>
                        <div class="col-md-8">
                            <div class="card-body">
                                <h5 class="card-title">Bienvenido, <c:out value="${usuario.nombre1}"/>!</h5>
                                <p class="card-text">
                                <ul class="list-group text-center">
                                    <li class="list-group-item">Identificación: <c:out value="${usuario.identificacion}"/></li>
                                    <li class="list-group-item">Email: <c:out value="${usuario.email}"/></li>                                    
                                    <li class="list-group-item">Domicilio: <c:out value="${usuario.domicilio}"/></li>
                                    <li class="list-group-item">Teléfono: <c:out value="${usuario.telefono}"/></li>
                                    <!-- Agrega más campos según sea necesario -->
                                </ul>
                                </p>
                                <p class="card-text text-center"><small class="text-muted">Actualmente desempeñas el cargo de</small>
                                </p>
                                <p style="font-weight: bold" class="text-center">
                                     <c:out value="${cargo.descripcion}"/>
                                </p>
                            </div>
                        </div> 
                    </div>
                </div>
                <div class="col-md-6">
                    <c:choose>
                        <c:when test="${usuario.idCargo == 1 || usuario.idCargo == 2}">
                            <div class="card mb-3 col-md-8 p-3 p-md-4 p-xl-5 mt-4 sombra">
                                <div class="card-body text-center">
                                    <h5 class="card-title mb-4">Opciones Administrativas</h5>
                                    <p class="card-text">
                                        <a href="ClienteServlet?action=list" class="btn btn-outline-primary">Consultar Clientes</a>
                                    </p>
                                </div>
                            </div>
                        </c:when>
                        <c:otherwise>
                            <div class="card mb-3 col-md-8 p-3 p-md-4 p-xl-5 mt-4 sombra">
                                <div class="card-body">
                                    <h5 class="card-title">Aviso</h5>
                                    <p class="card-text">
                                        El cargo de tu usuario no tiene menús asignados.
                                    </p>
                                </div>
                            </div>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </div>
    </body>
</html>
