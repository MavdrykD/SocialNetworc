<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%--
  Created by IntelliJ IDEA.
  User: Дімон
  Date: 07.06.2017
  Time: 12:50
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <meta charset="UTF-8">
    <%--шукає файл стилізації--%>
    <link rel="stylesheet" type="text/css" href="/css/madalWindov.css">
    <%--шукає файл стилізації--%>
    <link rel="stylesheet" type="text/css" href="/css/previewImg.css">
    <link rel="stylesheet" type="text/css" href="/css/grid.css">
    <link rel="stylesheet" type="text/css" href="/css/toolTip.css">
    <link rel="stylesheet" type="text/css" href="/css/headerStyle.css">
    <link rel="stylesheet" type="text/css" href="/css/tabs.css">
    <%--------------------------------------%>

    <%------------------------------------------%>
    <%--<link rel="stylesheet" type="text/css" href="/css/registrationForm.css">--%>

    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="http://code.jquery.com/jquery-2.0.2.min.js"></script>

    <link rel="stylesheet" type="text/css" href="css/imgareaselect-default.css" />
    <%--<script type="text/javascript" src="js/jquery.min.js"></script>--%>
    <script type="text/javascript" src="js/jquery.imgareaselect.pack.js"></script>

</head>
<body>
<div class="bodyContent">
    <div class="header"><tiles:insertAttribute name="header"/></div>

    <div class="myContainer">
        <div class="leftMenu"><tiles:insertAttribute name="leftMenu"/></div>

        <div class="body"><tiles:insertAttribute name="body"/></div>

        <div class="advertising"><tiles:insertAttribute name="advertising"/></div>
    </div>

    <div class="footer"><tiles:insertAttribute name="footer"/></div>

</div>
</body>
</html>
