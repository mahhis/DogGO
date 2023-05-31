<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="by.fpmibsu.doggo.controller.constants.*"%>
<!DOCTYPE html>
<html>
<head>
    <title>Sign Up</title>
    <style>
        /* CSS styles go here */
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
        }

        .container {
            max-width: 400px;
            margin: 0 auto;
            padding: 20px;
            background-color: #fff;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }

        form {
            margin-top: 20px;
        }

        label {
            font-weight: bold;
            color: #333;
        }

        input[type="text"],
        input[type="password"] {
            width: 100%;
            padding: 8px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }

        input[type="submit"] {
            width: 100%;
            padding: 8px;
            background-color: #FF8C00;
            color: #fff;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #FFA500;
        }

        .signup-link {
            display: block;
            text-align: center;
            margin-top: 10px;
            color: #333;
            text-decoration: none;
        }

        .signup-link:hover {
            color: #555;
        }
    </style>
</head>
<body>
<div class="container">
    <form action="<%=request.getContextPath()%>/Controller" method="post">
        <input type="hidden" name="command" value="SignUp">
        <label for="telephone_number">Telephone number:</label>
        <input type="text" name="telephone_number" id="telephone_number" value=""/>
        <br/>
        <label for="username">Username:</label>
        <input type="text" name="username" id="username" value=""/>
        <br/>
        <label for="password">Password:</label>
        <input type="password" name="password" id="password" value=""/>
        <br/>
        <input type="submit" value="Press me"/>
    </form>
    <a class="signup-link" href="Controller?command=GoToSignInPage">Login</a>
</div>
</body>
</html>
