<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/inc/header.jsp" />
<c:set var="nav" value="cocktails"></c:set>
<%@ include file="/inc/navbar.jsp"%>
<div class="container">
	<div class="page-header" id="banner">
		<div class="row">
			<div class="col-lg-8 col-md-7 col-sm-6">
				<h1>
					<c:out value="${action}" default="pb" />
					un cocktail
				</h1>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="well bs-component col-md-5">
			<c:choose>
				<c:when test="${action.equals('Ajouter')}">
					<c:url value="/cocktails/add.html" var="actionUrl" />
				</c:when>
				<c:when test="${action.equals('Modifier')}">
					<c:url value="/cocktails/mod.html" var="actionUrl" />
				</c:when>
				<c:when test="${action.equals('Effacer')}">
					<c:url value="/cocktails/del.html" var="actionUrl" />
				</c:when>
				<c:otherwise>
					<c:url value="/cocktails/add.html" var="actionUrl" />
				</c:otherwise>
			</c:choose>
			<form action="${actionUrl}" method="POST">
				<fieldset>
					<input type="hidden" name="id" value="${cocktail.id}" />
					<c:if test="${action.equals('Effacer')}">
						<input type="hidden" name="name" value="${cocktail.name}" />
						<input type="hidden" name="price" value="${cocktail.price}" />
						<input type="hidden" name="alcoholic"
							value="${cocktail.alcoholic}" />
					</c:if>
					<div class="form-group">
						<label for="name">Nom: </label> <input id="name" name="name"
							class="form-control" value="${cocktail.name}"
							<c:if test="${action.equals('Effacer')}">disabled=""</c:if> />
					</div>
					<div class="form-group">
						<label for="name">Prix: </label> <input id="price" name="price"
							class="form-control" value="${cocktail.price}"
							<c:if test="${action.equals('Effacer')}">disabled=""</c:if> />
					</div>
					<div class="form-group">
						<!-- default if unchecked -->
						<input type="hidden" name="alcoholic" value="0" />
						<label for="alcoholic"> Alcoolisé:<input type="checkbox"
							id="alcoholic" name="alcoholic" class="form-control"
							<c:if test="${cocktail.alcoholic}">checked</c:if>
							<c:if test="${action.equals('Effacer')}">disabled=""</c:if>>
						</label>
					</div>
					<button type="button" class="btn btn-default" data-toggle="modal"
						data-target="#validationModal">Valider</button>
					<!-- 					<button class="btn btn-default">Valider</button> -->
				</fieldset>
				<!-- Modal -->
				<c:set var="entityName" value="le cocktail" />
				<%@ include file="/inc/confirmModal.jsp"%>
			</form>
		</div>
	</div>
</div>
<jsp:include page="/inc/footer.jsp" />
