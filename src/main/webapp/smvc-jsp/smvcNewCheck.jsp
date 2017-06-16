<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Checks page</title>
</head>
<body>


<form action="" method="POST">
    <p>Data of Pourches: <input type="date" name="dataPourches" value="${dataPourches}">${dataPourchesError}</p>
    <p>Sum Of Check: <input type="long" name="sumOfCheck" value="${sumOfCkeck}"></p>
    <p>Shop Name: <input type="text" name="shopName" value="${shopName}"></p>
    <p>User: <select name="userID">${jspUserList}</select></p>
    <p>Users Money Account: <select name="userMoneyAccountID">${jspUsersMoneyAccountList}</select></p>
    <p>Details Allow: <input type="bit" name="detailsAllow" value="${detailsAllow}"></p>
    <p>Comments: <input type="text" name="comments" value="${comments}"></p>
    <input type="submit" value="Send" /><br>
    ${javaError}
</form>


</body>
</html>
