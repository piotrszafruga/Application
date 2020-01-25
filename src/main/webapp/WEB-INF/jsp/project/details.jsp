<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Project details</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
          crossorigin="anonymous">
    <link href="../css/my.css" rel="stylesheet">
</head>
<body>

<p>Project details:</p>
<br/>

${project.created} <br/>
${project.name} <br/>
${project.idFromName} <br>
${project.description} <br/>
Users:
<c:forEach items="${project.users}" var="var">
    ${var.firstName} ${var.lastName} <br/>
</c:forEach>

<p></p>
<a href="/project" class="btn btn-secondary my-2">Back</a>


<%@ include file="../parts/footer.jsp" %>
</body>
</html>