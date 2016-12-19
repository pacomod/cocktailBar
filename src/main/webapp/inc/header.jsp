<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>TP Cocktail-Bar</title>
<c:url value="/webjars/bootstrap/3.1.0" var="bootstrapUrl" />
<link rel="stylesheet" href="${bootstrapUrl}/css/bootstrap.min.css">
<link rel="stylesheet" href="<c:url value='/css/cerulean.css'/>"/>
<c:url value="/webjars/jquery/3.1.1-1/jquery.min.js" var="jqueryUrl" />
<script src="${jqueryUrl}"></script>
<script src="${bootstrapUrl}/js/bootstrap.min.js"></script>
</head>
<body>

