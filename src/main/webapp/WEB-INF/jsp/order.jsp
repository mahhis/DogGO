<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Dog Walking Order</title>
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

    .checkbox-grid {
      display: grid;
      grid-template-columns: repeat(3, 1fr);
      gap: 10px;
    }

    .checkbox-item {
      display: flex;
      align-items: center;
    }

    .checkbox-item input[type="checkbox"] {
      margin-right: 5px;
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

    .add-pet-button {
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

    .add-pet-button:hover {
      background-color: #333;
    }
  </style>
</head>
<body>
<h1>Dog Walking Order</h1>

<c:choose>
  <c:when test="${empty sessionScope.pets}">
    <form action="Controller" method="POST">
      <input type="hidden" name="command" value="GoToAddPetPage">
      <button type="submit" class="add-pet-button">Add a Pet</button>
    </form>
  </c:when>
  <c:otherwise>
    <form action="Controller" method="POST">
      <div class="form-group">
        <label>Select Pets:</label>
        <div class="checkbox-grid">
          <c:forEach var="pet" items="${sessionScope.pets}">
            <div class="checkbox-item">
              <input type="checkbox" id="pet_${pet.petId}" name="pets" value="${pet.petId}">
              <label for="pet_${pet.petId}">${pet.name}</label>
            </div>
          </c:forEach>
        </div>
      </div>

      <div class="form-group">
        <label for="datetime">Date and Time:</label>
        <input type="datetime-local" id="datetime" name="datetime" required>
      </div>

      <div class="form-group">
        <label for="price">Price (USD):</label>
        <input type="number" id="price" name="price" min="0" step="0.01" required>
      </div>

      <input type="hidden" name="command" value="PlaceDogWalkingOrder">

      <input type="submit" value="Submit Order" class="submit-button">
    </form>
  </c:otherwise>
</c:choose>
</body>
</html>
