<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/css/add.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <title>Document</title>
</head>
<body>
    <div class="cuadro">
        <div class="alert alert-danger" role="alert">
            <form:form class="center" action="/lookify/add" method="post" modelAttribute="lookify">
            <p>
        <form:label path="title">Title</form:label>
        <form:errors path="title"/>
        <form:input  path="title"/>
    </p>
    <p>
        <form:label path="artista">Artist</form:label>
        <form:errors path="artista"/>
        <form:input path="artista"/>
    </p>    
    <p>
        <form:label path="calificacion">Rating</form:label>
        <form:errors path="calificacion"/>
        <form:input  type="number" min="1" max="10" path="calificacion"/>
    </p>
     
    <input class="buttom" type="submit" value="add"/>
</form:form>    
</div>
</div>
</body>
</html>