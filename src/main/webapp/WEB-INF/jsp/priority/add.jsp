<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add Project</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
          crossorigin="anonymous">
    <link href="../css/my.css" rel="stylesheet">
</head>
<body>

<p>Add project</p>

<form:form method="post" modelAttribute="priority">

    Name: <form:input path="name" /> <br />
    <form:errors path="name"/> <br/>
    Active: <form:checkbox path="active"/> <br/>
    <form:errors path="active"/> <br/>

    <input type="submit" value="Add" class="btn btn-primary my-2"/>
    <a href="/admin" class="btn btn-secondary my-2">Back</a>

</form:form>



<%@ include file="../parts/footer.jsp" %>
</body>
</html>