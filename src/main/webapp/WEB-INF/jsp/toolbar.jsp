<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
  <title>Toolbar Example</title>
  <style>
    /* CSS styles for the toolbar */
    .toolbar {
      background-color: #333;
      color: #fff;
      padding: 10px;
      display: flex;
      justify-content: space-between;
    }

    .toolbar a {
      color: #fff;
      text-decoration: none;
      margin-right: 10px;
    }
  </style>
</head>
<body>
<div class="toolbar">
  <a href="Controller?command=GoToMainPage">Back</a>
  <a href="walks.jsp">Walks</a>
  <a href="pets.jsp">Pets</a>
</div>
<!-- Rest of your content here -->
</body>
</html>
