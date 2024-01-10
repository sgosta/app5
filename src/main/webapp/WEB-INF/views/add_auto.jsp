<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>

<head>
  <title>Aggiungi Auto</title>
</head>

<body>

<h1 align="center">Aggiungi una nuova auto</h1>

<div align="center">
  <form:form modelAttribute="auto" action="save_auto" method="POST">
    <form:hidden path="id"/>
    <label>Marca: </label>
    <form:input path="marca"/>
    <br/>
    <label>Modello: </label>
    <form:input path="modello" />
    <br/>
    <label>Cilindrata: </label>
    <form:input path="cilindrata"/>
    <br/>
    <label>Cavalli: </label>
    <form:input path="cavalli"/>
    <br/>
    <label>Coppia: </label>
    <form:input path="coppia"/>
    <br/>
    <label>Colore: </label>
    <form:input path="colore"/>
    <br/>
    <input type="submit" value="Aggiungi o Aggiorna" size="20%">

  </form:form>
</div>

<div align="center">
  <form action="http://localhost:8080/app5/">
    <input type="submit" value="Torna alla Lista di Auto">
  </form>
</div>

</body>

</html>
