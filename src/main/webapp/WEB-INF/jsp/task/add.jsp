<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add Task</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
          crossorigin="anonymous">
    <link href="../css/my.css" rel="stylesheet">

</head>
<body>
<p>Add Task:</p>

<h6>${task.project.name}<h6/>

<form:form method="post" modelAttribute="task">

    Topic: <br />
    <form:input path="topic" /> <br />
    <form:errors path="topic"/> <br/>

    Description: <br />
    <form:textarea path="description" rows = "10" cols="45"/> <br /><br />

    User: <br />
    <form:select path="user.id" items="${project.users}"
                 itemLabel="fullName" itemValue="id"/> <br/>
    <form:errors path="user"/> <br/>

    Status: <br />
    <form:select path="status.id" items="${statuses}"
                 itemLabel="name" itemValue="id"/> <br/>
    <form:errors path="status"/> <br/>

    Priority: <br />
    <form:select path="priority.id" items="${priorities}"
                 itemLabel="name" itemValue="id"/> <br/>
    <form:errors path="priority"/> <br/>

    <input type="submit" value="Add" class="btn btn-primary my-2"/>
    <a href="/project/tasks/${project.id}" class="btn btn-secondary my-2">Back</a>

</form:form>


<%@ include file="../parts/footer.jsp" %>
</body>
</html>