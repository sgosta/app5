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
    <form:input path="marca" cssStyle="margin-bottom: 10px"/>
    <br/>
    <label style="margin-left: -16px">Modello: </label>
    <form:input path="modello" cssStyle="margin-bottom: 10px"/>
    <br/>
    <label style="margin-left: -27px">Cilindrata: </label>
    <form:input path="cilindrata" cssStyle="margin-bottom: 10px"/>
    <br/>
    <label style="margin-left: -3px">Cavalli: </label>
    <form:input path="cavalli" cssStyle="margin-bottom: 10px"/>
    <br/>
    <label style="margin-left: -3px">Coppia: </label>
    <form:input path="coppia" cssStyle="margin-bottom: 10px"/>
    <br/>
    <label>Colore: </label>
    <form:input path="colore" cssStyle="margin-bottom: 10px"/>
    <br/>
    <input type="submit" value="Aggiungi o Aggiorna" size="20%" style="margin: 15px">

  </form:form>
</div>

<div align="center">
  <form action="http://localhost:8080/app5/">
    <input type="submit" value="Torna alla Lista di Auto">
  </form>
</div>

</body>
</html>
