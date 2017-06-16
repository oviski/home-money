<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Check OK page</title>
</head>
<body>

        <p>New Check added successful</p>

        <input type="button" onclick="location.href='${urlAddCheck}';" value="Add new check" />

        &nbsp &nbsp &nbsp

        <input type="button" onclick="location.href='${urlAllChecks}';" value="View ALL CHECKS" />
<p>
        <a href=${urlAddCheck}>add new check</a>
</p>
</body>
</html>
