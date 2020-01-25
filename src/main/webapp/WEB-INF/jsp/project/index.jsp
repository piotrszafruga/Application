<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Projects</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
          crossorigin="anonymous">
    <link href="../css/my.css" rel="stylesheet">
</head>
<body>

<p>Projects:</p>
<br/>
<c:forEach items="${projects}" var="var">
    Created: ${var.created} <br/>
    Project name: ${var.name} <br/>
    Identificator: ${var.idFromName} <br/>
    Active: ${var.active} <br/>

    <a href='<c:url value="/project/tasks/${var.id}"/>' class="btn btn-secondary my-2">Tasks</a>

    <a href='<c:url value="/project/details/${var.id}"/>' class="btn btn-secondary my-2">Details</a>

    <a href='<c:url value="/project/edit/${var.id}"/>' class="btn btn-secondary my-2">Edit</a>

    <a href="/admin" class="btn btn-secondary my-2">Back</a>

    <p> ---- </p>
</c:forEach>

<%@ include file="../parts/footer.jsp" %>
</body>
</html>