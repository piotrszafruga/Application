<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Homepage</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
          crossorigin="anonymous">
    <link href="../css/my.css" rel="stylesheet">

</head>
<body>

<div class="btn btn-block">
<p></p>
    <a href="/admin" class="btn btn-secondary my-2">Admin Page</a>
    <p></p>

<h5>Latest projects:</h5>
<c:forEach items="${latestProjects}" var="var">
    ${var.name} <br/>
</c:forEach>

<br/>

<h5>Latest activities: </h5>
<c:forEach items="${latestActivities}" var="var">
    Timestamp: ${var.happened} <br/>
    User name: ${var.userName} <br/>
    Project name: ${var.projectName} <br/>
    Task name: ${var.action} <br/>
    <br/>
<%--    <a href="/one">link</a> <br/>--%>
</c:forEach>

<a href="/admin" class="btn btn-secondary my-2">Admin Page</a>

</div>

<%@ include file="parts/footer.jsp" %>
</body>
</html>