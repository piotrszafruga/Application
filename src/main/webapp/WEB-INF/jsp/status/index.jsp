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

<p>Statuses:</p>

<c:forEach items="${statuses}" var="var">
    ${var.name}, ${var.statusNumber}, active: ${var.active} <br/>
</c:forEach>

<a href="/status/add" class="btn btn-primary my-2">New status</a>

<a href="/admin" class="btn btn-secondary my-2">Back</a> <br/>

<%@ include file="../parts/footer.jsp" %>
</body>
</html>