<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/css/show.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <title>Show</title>
</head>
<body class="fondo">
    <header>
        <a href="/dashboard" class="link-dark">Dashboard</a>
    </header>
    <div id="cuadro">
        <div class="alert alert-success" role="alert">
            <p class="font">Titulo: <c:out value="${lookify.title}"/></p>
            <p class="font">Artista: <c:out value="${lookify.artista}"/></p>
            <p class="font">Calificacion: <c:out value="${lookify.calificacion}"/></p>
            <form action="/lookify/${lookify.id}" method="post">
                <input type="hidden" name="_method" value="delete">
                <input class="buttom" type="submit" value="Delete">
            </form>
        </div>
    </div>
</body>
</html>