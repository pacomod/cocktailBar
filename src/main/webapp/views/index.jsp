<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/inc/header.jsp" />
<c:set var="nav" value="accueil"></c:set>
<c:set var="menub" value="${menus}" scope="application" />
<%@ include file="/inc/navbar.jsp"%>
<div class="container">
	<div class="page-header" id="banner">
		<div class="row">
			<div class="col-lg-8 col-md-7 col-sm-6">
				<h1>Bienvenue dans l'application CocktailBar</h1>
			</div>
		</div>
	</div>
	<div class="container">
		Menu:
		<ul>
			<c:forEach items="${menus}" var="menu">
				<c:url value="${menu.url}.html" var="menuUrl" />
				<li><a href="${menuUrl}">${menu.title}</a></li>
			</c:forEach>
		</ul>
	</div>
</div>
<jsp:include page="/inc/footer.jsp" />
