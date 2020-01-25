<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Project's Tasks</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
          crossorigin="anonymous">
    <link href="../css/my.css" rel="stylesheet">

</head>


<body>

<br/><br/><br/>


<h5>Project's Tasks:</h5>

<a href='<c:url value="/task/add/${projectId}"/>' class="btn btn-primary my-2">Add task</a>
<p></p>

<c:forEach items="${tasks}" var="var">
    Created: ${var.created} <br/>
    Topic: ${var.topic} <br/>
    User: ${var.user.firstName} ${var.user.lastName} <br/>
    <a href='<c:url value="/task/details/${var.id}"/>' class="btn btn-secondary my-2">Details</a>
    <a href='<c:url value="/task/edit/${projectId}/${var.id}"/>' class="btn btn-secondary my-2">Edit</a>
    <a href='<c:url value="/task/delete/${projectId}/${var.id}"/>'class="btn btn-danger my-2">Delete</a>
    <a href="/project" class="btn btn-secondary my-2">Back</a>
    <p> </p>
</c:forEach>



<%@ include file="../parts/footer.jsp" %>
</body>
</html>