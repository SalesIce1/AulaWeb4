<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="model.Pais" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="UTF-8">
		<style type="text/css">
	        .container{
            max-width:1280;
            margin: auto;
            }
            .titulo{
            text-align:center;
            border-bottom: solid Ipx #ccc;
            margin-bottom: 8px;
            }
            .dado{
            border:solid Ipx black;
            border-radius: 8px;
            backgound-color: #ccc;
            margin-bottom: 9px;
            padding: 12px;
            }
		</style>
<title>País Cadastrado</title>
</head>
<body>
	<%Pais pais = (Pais) request.getAttribute("pais");%>
	<div class="container">
		<h1 class="titulo">Pais cadastrado</h1>
		<div class="id">ID: <%= +pais.getId() %></div>
		<div class="nome">Nome: <% out.println(pais.getNome());%></div>
		<div class="população">População: <%= pais.getPopulacao() %></div>
		<div class="area">Area: <%= pais.getArea() %></div>
	</div>
</body>
</html>