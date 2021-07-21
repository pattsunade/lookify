<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <title>Search</title>
</head>
<body>
    <h1>Songs by artist: <c:out value="${busqueda}"/></h1>
    <form action="/search">
       <input type="text" name="busqueda" value="<c:out value="${artista}"/>">
       <input type="submit" value="New Search">
    </form>
     <a href="/dashboard">Dashboard</a>
    <table>
    <thead>
        <tr>
            <th>Title</th>
            <th>Calificacion</th>
            <th>action</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${search}" var="lookify">
        <tr>
            <td><a href="/lookify/${lookify.id}"><c:out value="${lookify.title}"/></a></td>
            <td><c:out value="${lookify.calificacion}"/></td>
            <td>
                <form class="alinear" action="/lookify/${lookify.id}" method="post">
                    <input type="hidden" name="_method" value="delete">
                    <input class="link" type="submit" value="delete">
                </form>
            </td>
        </tr>
        </c:forEach>
    </tbody>
</table>
    
</body>
</html>