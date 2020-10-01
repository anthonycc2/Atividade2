<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="basica.Cliente" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	List<Cliente> lista = (List<Cliente>) request.getAttribute("clientes");
	for(int i=0; i<lista.size(); i++){
		out.println(lista.get(i).getCpf() + "<br/>");
	}
	%>
</body>
</html>