<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Informacion Matriculas</title>
    </head>
    <body>
        <h1>Informacion Matriculas</h1>
        <form action="./MatriculaServlet" method="POST">
            <table>
                <tr>
                    <td>Codigo Curso</td>
                    <td><input type="text" name="codCurso" value="${matriculacursos.cursos.codCurso}" /></td>
                </tr>
                <tr>
                    <td>ID Estudiante</td>
                    <td><input type="text" name="studentid" value="${matriculacursos.estudiante.studentid}" /></td>
                </tr>
                <tr>
                    <td>Fecha</td>
                    <td><input type="text" name="fecha" value="${matriculacursos.fecha}" /></td>
                </tr>
                <tr>
                    <td>Precio</td>
                    <td><input type="text" name="precio" value="${matriculacursos.precio}" /></td>
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
            <th>Cod Curso</th>
            <th>ID Estudiante</th>
            <th>Fecha</th>
            <th>Precio</th>
            <c:forEach items="${allMatriculaCursos}" var="matriculacursos">
                <tr>
                    <td>${matriculacursos.cursos.codCurso}</td>
                    <td>${matriculacursos.estudiante.studentid}</td>
                    <td>${matriculacursos.fecha}</td>
                    <td>${matriculacursos.precio}</td>
                </tr>
            </c:forEach> 
        </table>
    </body>
</html>

