<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <meta name="_csrf" content="${_csrf.token}"/>
    <meta name="_csrf_header" content="${_csrf.headerName}"/>

    <title><spring:message code="app.title"/></title>
    <base href="${pageContext.request.contextPath}/"/>

    <link rel="stylesheet" href="resources/css/style.css">
    <link rel="stylesheet" href="webjars/noty/3.1.0/demo/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="webjars/noty/3.1.0/lib/noty.css">
    <link rel="stylesheet" href="webjars/bootstrap/4.4.0/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="webjars/font-awesome/5.12.0/css/all.css">

<%--http://stackoverflow.com/a/24070373/548473--%>
    <script type="text/javascript" src="webjars/jquery/3.4.1/jquery.min.js"></script>
    <script type="text/javascript" src="webjars/bootstrap/4.4.0/dist/js/bootstrap.min.js" defer></script>
    <script type="text/javascript" src="webjars/jquery-serialize-object/2.1.0/jquery.serialize-object.min.js"></script>
    <script type="text/javascript" src="webjars/noty/3.1.0/lib/noty.min.js" defer></script>
    <script type="text/javascript" src="resources/js/notyUtil.js" defer></script>
</head>