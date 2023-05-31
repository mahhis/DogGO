<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<head>
    <title>Make order</title>
    <style>
        /* CSS styles go here */
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
        }

        h1 {
            text-align: center;
            color: #FF8C00;
            margin-top: 40px;
        }

        .walker-container {
            display: flex;
            flex-wrap: wrap;
            justify-content: space-between;
            margin-top: 20px;
        }

        .walker {
            flex-basis: calc(33.33% - 20px); /* Расчет ширины с учетом отступов */
            height: 150px;
            background-color: #FF8C00;
            color: #FFF;
            text-align: center;
            margin-bottom: 20px;
            border-radius: 10px;
            box-shadow: 0 0 5px rgba(0, 0, 0, 0.3);
            transition: background-color 0.3s ease-in-out;
        }

        .walker:hover {
            background-color: #333;
        }

        .walker a {
            text-decoration: none;
            color: #FFF;
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            width: 100%;
            height: 100%;
        }

        .walker p {
            margin-top: 10px;
        }
    </style>
</head>
<body>

<%@ include file="toolbar.jsp" %>
<h1>Top walkers for you</h1>

<div class="walker-container">
    <c:forEach var="walker" items="${sessionScope.walkers}">
        <div class="walker">
            <a href="Controller?command=GoToViewWalkerPage&walkerId=${walker.walkerId}">
                <c:out value="${walker.walkerName}"/>
                <p>Rating: <c:out value="${walker.rating}"/></p>
                <p>Number of Walks: <c:out value="${walker.numberWalks}"/></p>
            </a>
        </div>
    </c:forEach>
</div>

</body>
</html>
