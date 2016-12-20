<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/inc/header.jsp" />
<c:set var="nav" value="cocktails"></c:set>
<%@ include file="/inc/navbar.jsp"%>
<div class="container">
  <div class="cocktail-details">
  <h2>Modifier le cocktail</h2>
  <form:form >
  
  </form:form>
  </div>
  <div class="cocktail-ingredients">
  </div>
</div>
<jsp:include page="/inc/footer.jsp" />
