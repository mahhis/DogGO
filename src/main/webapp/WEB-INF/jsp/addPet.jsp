<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Add Pet</title>
  <style>
    /* CSS styles go here */
    body {
      font-family: Arial, sans-serif;
      background-color: #f2f2f2;
      color: #000;
      padding: 20px;
    }

    h1 {
      text-align: center;
      color: #FF8C00;
      margin-bottom: 20px;
    }

    .form-group {
      margin-bottom: 20px;
    }

    .form-group label {
      display: block;
      font-weight: bold;
      margin-bottom: 5px;
    }

    .form-group select,
    .form-group input[type="text"],
    .form-group input[type="number"] {
      width: 100%;
      padding: 10px;
      border-radius: 5px;
      border: 1px solid #ccc;
    }

    .submit-button {
      display: block;
      width: 200px;
      padding: 10px;
      margin: 20px auto;
      background-color: #FF8C00;
      color: #FFF;
      text-align: center;
      text-decoration: none;
      border-radius: 5px;
      border: none;
    }

    .submit-button:hover {
      background-color: #333;
    }
  </style>
</head>
<body>
<h1>Add Pet</h1>

<form action="Controller" method="POST">
  <div class="form-group">
    <label for="name">Name:</label>
    <input type="text" id="name" name="name" required>
  </div>

  <div class="form-group">
    <label for="age">Age:</label>
    <input type="number" id="age" name="age" min="0" required>
  </div>

  <div class="form-group">
    <label for="breed">Breed:</label>
    <select id="breed" name="breed" required>
      <c:forEach var="breed" items="${sessionScope.breeds}">
        <option value="${breed}">${breed}</option>
      </c:forEach>
    </select>
  </div>

  <div class="form-group">
    <label for="weight">Weight (kg):</label>
    <input type="number" id="weight" name="weight" min="0" step="0.01" required>
  </div>

  <input type="hidden" name="command" value="AddPet">

  <input type="submit" name="addPet" value="Add Pet" class="submit-button">
</form>
</body>
</html>
