<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/css/top.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <title>Document</title>
</head>
<body class="fondo">
    <div class="container">
        <h1>Top Ten Songs</h1>
        <table class="table table-dark table-striped">
            <c:forEach var="lookify" items="${top}">
                <tr>
                    <td><c:out value="${lookify.calificacion}"/></td>
                    <td><a href="/lookify/${lookify.id}" class="link-light"><c:out value="${lookify.title}"/></a></td>
                    <td><c:out value="${lookify.artista}"/></td>
                </tr>
            </c:forEach>
        </table>

    </div>
    
</body>
</html>