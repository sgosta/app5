<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>

<style>
    .form-group {
        margin-bottom: 25px;
    }
</style>

<html style="background-color: darkgray">
<head>
  <title style="color: chocolate">Aggiungi Auto</title>
</head>
<body>
<h1 style="color: chocolate; align-content: center">Aggiungi una nuova auto</h1>

<div>
  <form:form modelAttribute="auto" action="save_auto" method="POST">
    <form:hidden path="id"/>
    <div class="form-group">
      <h3 style="margin-left: 40px; color: chocolate">Marca: </h3>
      <form:input path="marca" cssStyle="margin-left: 40px"/>
    </div>
    <div class="form-group">
      <h3 style="margin-left: 40px; color: chocolate">Modello: </h3>
      <form:input path="modello" cssStyle="margin-left: 40px"/>
    </div>
    <div class="form-group">
      <h3 style="margin-left: 40px; color: chocolate">Cilindrata: </h3>
      <form:input path="cilindrata" cssStyle="margin-left: 40px"/>
    </div>
    <div class="form-group">
      <h3 style="margin-left: 40px;color: chocolate">Cavalli: </h3>
      <form:input path="cavalli" cssStyle="margin-left: 40px"/>
    </div>
    <div class="form-group">
      <h3 style="margin-left: 40px; color: chocolate">Coppia: </h3>
      <form:input path="coppia" cssStyle="margin-left: 40px"/>
    </div>
    <div class="form-group">
      <h3 style="margin-left: 40px; color: chocolate">Colore: </h3>
      <form:input path="colore" cssStyle="margin-left: 40px"/>
    </div>
    <input type="submit" value="Aggiungi o Aggiorna" size="20%" style="font-size: 20px; margin: 50px; background-color: aquamarine">

  </form:form>
</div>

<div align="center">
  <form action="http://localhost:8080/app5/">
    <input type="submit" value="Torna alla Lista di Auto" style="font-size: 20px; background-color: aquamarine; margin-top: 50px">
  </form>
</div>

</body>
</html>
