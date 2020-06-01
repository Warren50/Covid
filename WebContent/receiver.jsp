<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
ca peut donner un truc genre!!!
 <form action="ReceiverController" method="post">
 <table>
   <tr>
    <td>id de l'user</td>
    <td>
     <input type="text" name="user"></input>
    </td>
   </tr>
   <tr>
     <td>phone</td>
     <td>
      <input type="text" name="phone" ></input>
     </td>
   </tr>
    <tr>
    <td>code</td>
    <td><input type="text" name="code"></input>
    </td>
    </tr>
    <tr>
     <td><input type="submit" value="ajouter" name="action"></input></td>
    </tr>
    </table>
  
 </form>
 <div>
   <table  class="table1">
     <tr>
        <th>id</th>
         <th>card_id</th> 
         <th>id_user_receiver</th>
          <th>id_valider</th>
          <th>phone</th>
          <th>code</th>
     </tr>
     <c:forEach items="${model.listeReceive}" var="p">
       <tr>
          <td>${p.id }</td>
          <td>${p.card_id }</td>
          <td>${p.id_user_receiver }</td>
          <td>${p.id_valider }</td>
          <td>${p.phone}</td>
          <td>${p.code }</td>
           <td> <a href="ReceiverController?action=delete&ref=${p.id}">supprimer</a></td>
          
       </tr>
     </c:forEach>
   </table>
 </div>
</body>
</html>