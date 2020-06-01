<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
     <td><input type="submit" value="ajouter"></input></td>
    </tr>
    </table>
  
 </form>
</body>
</html>