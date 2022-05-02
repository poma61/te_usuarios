<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.emergentes.modelo.User"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" 
              rel="stylesheet" 
              integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
              crossorigin="anonymous">
        <title>Edicion</title>
    </head>
    <body>

        <h1>
            <c:if test="${requestScope.op=='add'}" var="control" scope="request">
                Nuevo
            </c:if>    
            <c:if test="${requestScope.op=='editar'}" var="control" scope="request">
                Modificar
            </c:if>
            Usuario
        </h1>
        <div class="mb-3">
            <form action="UserController" method="post">
                <input type="hidden" name="id" value="${users.id}">   
                <table>

                    <tr>                                             
                        <td>Nombre:</td>
                        <td><input type="text" name="nombre" value="${users.nombre}" required></td>
                    </tr>
                    <tr>
                        <td>Correo:</td>
                        <td><input type="email" name="correo" value="${users.correo}" required></td>
                    </tr>
                    <tr>
                        <td>Clave:</td>
                        <td><input type="text" name="clave" value="${users.clave}" required></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input class="btn btn-primary" type="submit" value="Enviar"></td>
                    </tr>

                </table>
            </form>
            <p><a class="btn btn-primary" href="UserController">Volver</a></p>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" 
                integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" 
        crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"
                integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" 
        crossorigin="anonymous"></script>
    </body>
</html>
