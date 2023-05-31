<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Walker</title>
    <style>
        /* CSS styles go here */
        body {
            font-family: Arial, sans-serif;
            background-color: #FFF;
            color: #000;
            padding: 20px;
        }

        .walker-info {
            text-align: center;
            margin-bottom: 20px;
        }

        .walker-info h2 {
            margin-bottom: 10px;
        }

        .walker-info p {
            margin: 5px 0;
        }

        .order-button {
            display: block;
            width: 200px;
            padding: 10px;
            margin: 20px auto;
            background-color: #FF8C00;
            color: #FFF;
            text-align: center;
            text-decoration: none;
            border-radius: 5px;
        }

        .order-button:hover {
            background-color: #333;
        }

        .comments {
            margin-top: 40px;
        }

        .comment {
            border: 1px solid #FF8C00;
            padding: 10px;
            margin-bottom: 10px;
            border-radius: 5px;
        }

        .comment .author {
            font-weight: bold;
            color: #FF8C00;
            margin-bottom: 5px;
        }

        .comment .content {
            color: #000;
        }

        .add-comment-form {
            margin-top: 20px;
        }

        .add-comment-form textarea {
            width: 100%;
            height: 100px;
            margin-bottom: 10px;
            padding: 5px;
            border-radius: 5px;
        }

        .add-comment-form button {
            padding: 5px 10px;
            background-color: #FF8C00;
            color: #FFF;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        .add-comment-form button:hover {
            background-color: #333;
        }
    </style>
</head>
<body>
<div class="walker-info">
    <h2>Walker Information</h2>
    <p>Walker ID: <c:out value="${sessionScope.walkerId}"/></p>
    <!-- Display other walker information here -->
</div>

<a href="Controller?command=GoToOrderPage&walkerId=${sessionScope.walkerId}" class="order-button">Make Order</a>

<div class="comments">
    <h2>Comments</h2>
    <c:forEach var="comment" items="${sessionScope.comments}">
        <div class="comment">
            <p class="author"><c:out value="${comment.author.username}"/></p>
            <p class="content"><c:out value="${comment.content}"/></p>
        </div>
    </c:forEach>

    <div class="add-comment-form">
        <h3>Add Comment</h3>
        <form action="Controller" method="post">
            <input type="hidden" name="command" value="AddComment">
            <input type="hidden" name="walkerId" value="${sessionScope.walkerId}">
            <textarea name="content" placeholder="Enter your comment" required></textarea>
            <button type="submit">Submit</button>
        </form>
    </div>
</div>

</body>
</html>
