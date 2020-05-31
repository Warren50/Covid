<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gestion des symptomes</title>
</head>
<body>
	<h3><font color="blue">GESTION DES SYMPTOMES</font></h3>
	<form action="SymptomeController" method="post">
		<input type="text" name="nom" placeholder="Entrez le nom du symptome"/><br>
		<input type="text" name="description" placeholder="Entrez la description"/><br>
		<input type="submit" value="Ajouter" />
	</form>

</body>
</html>