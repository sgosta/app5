<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html style="background-color: darkgray">
<head>
  <title>Auto</title>
</head>
<h1 align="center" style="color: chocolate">Concessionaria</h1>
<h2 align="center" style="color: chocolate">Lista di tutte le auto correnti</h2>
<body>

<div align="center">
  <form action="search_auto" method="GET">
    <label for="searchText" style="color: chocolate">Ricerca Auto:</label>
    <input type="text" id="searchText" name="searchText"/>
    <input type="submit" value="Cerca" style="background-color: aquamarine"/>
  </form>
</div>

<div align="center">
  <form action="http://localhost:8080/app5/" method="GET">
    <input type="submit" value="Refresh" style="background-color: aquamarine">
  </form>
</div>

<div style="margin-left: 190px">
  <form action="reset" method="GET">
    <input type="submit" style="background-color: aquamarine" value="Azzera tabella" onclick="if(!(confirm('Procedere con il reset della tabella?'))) return false">
  </form>

  <form action="sort" method="GET">
    <label for="sortBy" style="color: chocolate">Ordina per:</label>
    <select id="sortByCol" name="sortCol" style="background-color: aquamarine">
      <option value="id" name="colonna">ID</option>
      <option value="marca" name="colonna">Marca</option>
      <option value="modello" name="colonna">Modello</option>
      <option value="cilindrata" name="colonna">Cilindrata</option>
      <option value="cavalli" name="colonna">Cavalli</option>
      <option value="coppia" name="colonna">Coppia</option>
      <option value="colore" name="colonna">Colore</option>
    </select>
    <select id="sortBy" name="sort" style="background-color: aquamarine">
      <option value="asc" name="ordine">Asc</option>
      <option value="desc" name="ordine">Desc</option>
    </select>
    <input type="submit" value="Ordina" style="background-color: aquamarine"/>
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
        <td style="background-color: aqua">${auto.cilindrata}cc</td>
        <td style="background-color: aqua">${auto.cavalli}cv</td>
        <td style="background-color: aqua">${auto.coppia}Nm</td>
        <td style="background-color: aqua">${auto.colore}</td>
        <td align="center" style="background-color: aquamarine"><a href="update_auto?id=${auto.id}" style="color: darkgreen">Aggiorna</a></td>
        <td align="center" style="background-color: aquamarine"><a href="delete_auto?id=${auto.id}"
                              onclick="if(!(confirm('Procedere con la eliminazione di questa auto?')))
                           return false" style="color: crimson">Elimina</a>
        </td>
      </tr>
    </c:forEach>
  </table>
</div>

<div align="center">
  <form action="add_auto">
    <input type="submit" value="==> Aggiungi Auto <==" style="margin: 10px; background-color: aquamarine; font-size: 20px">
  </form>
</div>

</body>

</html>
