<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
 <head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <title>Таблица</title>
  <style type="text/css">
   TABLE {
    width: 700px; /* Ширина таблицы */
    border-top: 2px solid #000; /* Линия сверху таблицы */
    border-bottom: 2px solid #000; /* Линия внизу таблицы */
   }
   TD, TH {
    padding: 3px; /* Поля вокруг содержимого ячеек */
   }
   TH {
    text-align: left; /* Выравнивание текста по левому краю */
    border-bottom: 1px solid #000; /* Линия под верхним заголовком */
   }
  </style>
 </head>
 <h1 style="color:blue;">List Of All Checks</h1>
 <a href = "newCheck">Add New Check </a><br><br>
 <body>
  <table cellspacing="0">
   <tr>
    <th>checkID</th><th>DataOfPourches</th><th>SumOfCheck</th><th>ShopName</th><th>userID</th><th>userMoneyAccountID</th><th>detailsAllow</th><th>Comments</th>
   </tr>
   ${jspChecksList}
  </table>
 </body>
</html>