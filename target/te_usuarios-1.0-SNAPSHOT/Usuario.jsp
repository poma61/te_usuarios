<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.List"%>
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
        <title>Usuarios</title>
    </head>
    <body>

        <h1>Gestion de Usuarios</h1>
        <div>
            <p><a class="btn btn-success" href="UserController?op=nuevo">Nuevo</a></p>
            <table border="1" class="table table-success table-striped">
                <tr>
                    <th>Id</th>
                    <th>Nombres</th>
                    <th>Correo</th>
                    <th>Clave</th>
                    <th>Modificar</th>
                    <th>Eliminar</th>
                </tr>
                <c:forEach var="item" items="${lis}">
                    <tr>
                        <td>${item.id}</td>
                        <td>${item.nombre}</td>
                        <td>${item.correo}</td>
                        <td>${item.clave}</td>
                        <td><a class="btn btn-primary" href="UserController?op=modificar&id=${item.id}">Modificar</a></td>
                        <td><a  class="btn btn-primary" href="UserController?op=eliminar&id=${item.id}">Eliminar</a></td>
                    </tr>  

                </c:forEach>



            </table>

        </div> 
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" 
                integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" 
        crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"
                integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" 
        crossorigin="anonymous"></script>
    </body>
</html>
