<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Task Details:</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
          crossorigin="anonymous">
    <link href="../css/my.css" rel="stylesheet">

</head>
<body>
<p>Task Details:</p>

<br/>

${task.created} <br/>
${task.topic} <br/>
${task.description} <br/>
${task.user.fullName} ${task.user.lastName}<br/>
${task.status.name} <br>
${task.priority.name} <br>

<p></p>
<a href="/project/tasks/${task.project.id}" class="btn btn-secondary my-2">Back</a>

<%@ include file="../parts/footer.jsp" %>
</body>
</html>