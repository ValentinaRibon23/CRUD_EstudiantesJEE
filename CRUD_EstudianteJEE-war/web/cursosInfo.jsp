<%-- 
    Document   : cursosInfo
    Created on : Apr 4, 2023, 8:29:29 PM
    Author     : Valentina Contreras
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student Information</title>
    </head>
    <body>
        <h1>Informacion cursos</h1>
        <form action="./CursosServlet" method="POST">
            <table>
                <tr>
                    <td>Codigo Curso</td>
                    <td><input type="text" name="codCurso" value="${cursos.codCurso}" /></td>
                </tr>
                <tr>
                    <td>Nombre Curso</td>
                    <td><input type="text" name="nombre" value="${cursos.nombre}" /></td>
                    
                </tr>
                <tr>
                    <td>Numero Creditos</td>
                    <td><input type="text" name="numCreditos" value="${cursos.numCreditos}" /></td>
                </tr>
                <tr>
                    <td>Semestre</td>
                    <td><input type="text" name="semestre" value="${cursos.semestre}" /></td>
                </tr>
                <tr>
                    <td># Estudiantes Admitidos</td>
                    <td><input type="text" name="numEstudiantesAdmintidos" value="${cursos.numEstudiantesAdmitidos}" /></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" name="action" value="Add" />
                        <input type="submit" name="action" value="Edit" />
                        <input type="submit" name="action" value="Delete" />
                        <input type="submit" name="action" value="Search" />
                    </td>
                </tr>
            </table>
        </form>
        <br>
        <table border="1">
            <th>ID curso</th>
            <th>Nombre</th>
            <th>Numero de Creditos</th>
            <th>Semestre</th>
             <th># Estudiantes Admitidos</th>
                <c:forEach items="${allCursos}" var="cursos">
                <tr>
                    <td>${cursos.codCurso}</td>
                    <td>${cursos.nombre}</td>
                    <td>${cursos.numCreditos}</td>
                    <td>${cursos.semestre}</td>
                    <td>${cursos.numEstudiantesAdmitidos}</td>
                </tr>
            </c:forEach> 
        </table>
    </body>
</html>

