<%-- 
    Document   : login
    Created on : 28/07/2024, 5:31:46 p. m.
    Author     : srcharcas
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link rel="stylesheet" href="css/styles.css">    
        <link rel="stylesheet" href="css/bootstrap/bootstrap.min.css">    
        <link rel="stylesheet" href="css/sweetalert2/sweetalert2.min.css">
    </head>
    <body>
        <section class="p-3 p-md-4 p-xl-5">
            <div class="container">
                <div class="card sombra">
                    <div class="row">
                        <div class="col-sm-12 col-md-6 text-bg-primary">
                            <div class="d-flex align-items-center justify-content-center h-100">
                                <div class="col-10 col-xl-8 py-3 mx-auto text-center">
                                    <h2 class="h1 mb-4">Supermercado</h2>
                                    <hr class="border-primary-subtle mb-4">
                                    <p class="lead m-0">Estás a punto de ingresar al sistema de gestión del supermercado</p>
                                </div>
                            </div>
                        </div>
                        <div class="col-12 col-md-6">
                            <div class="card-body p-3 p-md-4 p-xl-5">
                                <div class="row">
                                    <div class="col-12">
                                        <h3 class="text-center">Inciar Sesión</h3>
                                    </div>
                                </div>
                                <form action="UsuarioServlet?action=login" autocomplete="off">
                                    <div class="row gy-3 gy-md-4 overflow-hidden">
                                        <div class="col-12">
                                            <label for="identificacion" class="form-label">Identificacion: <span
                                                    class="text-danger">*</span></label>
                                            <input value="${usuario.identificacion}" type="text" class="form-control" name="identificacion"
                                                   id="identificacion">
                                        </div>
                                        <div class="col-12">
                                            <label for="password" class="form-label">Password: <span
                                                    class="text-danger">*</span></label>
                                            <input value="${usuario.password}" type="password" class="form-control" name="password" id="password">
                                        </div>
                                        <div class="col-12">
                                            <div class="d-grid mx-auto text-center">
                                                <input type="button" class="btn btn-primary col-md-6 mx-auto" onclick="validarFormulario()" value="Ingresar"></input>
                                                <button id="btn_accion" style="display: none" type="submit"></button>
                                            </div>
                                        </div>
                                        <!-- Mostrar mensaje de error si el parámetro error está presente -->
                                        <c:if test="${param.error == 'true'}">
                                            <script>
                                                document.addEventListener('DOMContentLoaded', function () {
                                                    mostrarModal('El usuario o el password no coincide con algún usuario registrado en el sistema</br> Por favor verifique', 'Inicio Sesión', 'error');
                                                });
                                            </script>
                                        </c:if>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </body>
    <script src="js/sweetalert2/sweetalert2.min.js" type="text/javascript"></script>
    <script src="js/login.js" type="text/javascript"></script>
</html>
