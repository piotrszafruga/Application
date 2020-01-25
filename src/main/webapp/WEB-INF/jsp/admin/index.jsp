<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Admin Page</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
          crossorigin="anonymous">
    <link href="../css/my.css" rel="stylesheet">
</head>
<body>

<br/><br/><br/><br/>
<br/><br/>

<div class="btn btn-block">
Projects:<br/>
<a href="/project" class="btn btn-secondary my-2" style="width:8%">Projects</a>
<a href="/project/add" class="btn btn-primary my-2" style="width:8%">New project</a>
<br/>

Users:<br/>
<a href="/user" class="btn btn-secondary my-1" style="width:8%"> Users </a>
<a href="/user/add" class="btn btn-primary my-2" style="width:8%"> New user </a>
<br/>

Users:<br/>
<a href="/status" class="btn btn-secondary my-2" style="width:8%">Statuses</a>
<a href="/status/add" class="btn btn-primary my-2" style="width:8%">New status</a>
<br/>

Priorities:<br/>
<a href="/priority" class="btn btn-secondary my-2" style="width:8%">Priorities</a>
<a href="/priority/add" class="btn btn-primary my-2" style="width:8%">New priority</a>
<br/>

    <p></p>
    <a href="/" class="btn btn-secondary my-2">Back</a>
</div>


<%@ include file="../parts/footer.jsp" %>
</body>
</html>