<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <link rel="stylesheet" href="/css/dashboard.css">
    <title>Dashboard</title>
</head>
<body class="container">
    <header>
        <a href="/lookify/add" class="link-dark">Add</a>
        <a href="/lookify/top" class="link-dark" >Top Songs</a>
        <form action="/search" class="buscador">
            <input class="barra" type="text" name="busqueda">
            <input class="buttom" type="submit" value="New Search">
        </form>
    </header>
    
    <div>
        <table class="table table-dark table-striped">
    <thead>
        <tr>
            <th>Title</th>
            <th>Rating</th>
            <th>Action</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${lookify}" var="lookify">
        <tr>
            <td><a href="/lookify/${lookify.id}" 
                ><c:out value="${lookify.title}"/></a></td>
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
    </div>


</body>
</html>
 private List<Tag> tags = new ArrayList<>()