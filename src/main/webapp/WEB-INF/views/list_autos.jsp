<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
  <title>Auto</title>
</head>
<h1 align="center">Concessionaria</h1>
<h2 align="center">Lista di tutte le auto correnti</h2>
<body>

<div align="center">
  <form action="search_auto" method="GET">
    <label for="searchText">Ricerca Auto:</label>
    <input type="text" id="searchText" name="searchText"/>
    <input type="submit" value="Cerca"/>
  </form>
</div>
<div align="center">
  <form action="http://localhost:8080/app5/" method="GET">
    <input type="submit" value="Refresh">
  </form>
</div>
<div style="margin-left: 190px">
  <form action="reset" method="GET">
    <input type="submit" value="Azzera tabella" onclick="if(!(confirm('Procedere con il reset della tabella?'))) return false">
  </form>
</div>
<div align="center">
  <table border="5" width="80%">
    <thead>
    <tr>
      <td style="background-color: aquamarine">ID</td>
      <td style="background-color: aquamarine">Marca</td>
      <td style="background-color: aquamarine">Modello</td>
      <td style="background-color: aquamarine">Cilindrata</td>
      <td style="background-color: aquamarine">Cavalli</td>
      <td style="background-color: aquamarine">Coppia</td>
      <td style="background-color: aquamarine">Colore</td>
    </tr>
    </thead>

    <c:forEach var="auto" items="${loadedAutos}">
      <tr>     <%--I campi del model sono privati, ma la jsp chiama internamente i rispettivi getters--%>
        <td style="background-color: aqua">${auto.id}</td>
        <td style="background-color: aqua">${auto.marca}</td>
        <td style="background-color: aqua">${auto.modello}</td>
        <td style="background-color: aqua">${auto.cilindrata}</td>
        <td style="background-color: aqua">${auto.cavalli}</td>
        <td style="background-color: aqua">${auto.coppia}</td>
        <td style="background-color: aqua">${auto.colore}</td>
        <td align="center"><a href="update_auto?id=${auto.id}" style="color: darkgreen">Update</a></td>
        <td align="center"><a href="delete_auto?id=${auto.id}"
                              onclick="if(!(confirm('Procedere con la eliminazione di questa auto?')))
                           return false" style="color: crimson">Delete</a>
        </td>
      </tr>
    </c:forEach>
  </table>
</div>

<div align="center">
  <form action="add_auto">
    <input type="submit" value="==> Aggiungi Auto <==" style="margin: 10px">
  </form>
</div>

</body>

</html>
