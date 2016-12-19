<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/inc/header.jsp" />
<c:set var="nav" value="ingredients"></c:set>
<%@ include file="/inc/navbar.jsp"%>
<div class="container">
	<div class="page-header" id="banner">
		<div class="row">
			<div class="col-lg-8 col-md-7 col-sm-6"></div>
			<h1>
				<c:out value="${action}" default="pb" />
				un Ingrédient
			</h1>
		</div>
	</div>
	<div class="container">
		<div class="well bs-component col-md-5">
			<c:choose>
				<c:when test="${action.equals('Ajouter')}">
					<c:url value="/ingredients/add.html" var="actionUrl" />
				</c:when>
				<c:when test="${action.equals('Modifier')}">
					<c:url value="/ingredients/mod.html" var="actionUrl" />
				</c:when>
				<c:when test="${action.equals('Effacer')}">
					<c:url value="/ingredients/del.html" var="actionUrl" />
				</c:when>
				<c:otherwise>
					<c:url value="/ingredients/add.html" var="actionUrl" />
				</c:otherwise>
			</c:choose>
			<form action="${actionUrl}" method="POST">
				<fieldset>
					<input type="hidden" name="id" value="${ingredient.id}" />
					<c:if test="${action.equals('Effacer')}">
						<input type="hidden" name="name" value="${ingredient.name}" />
						<input type="hidden" name="state" value="${ingredient.state}" />
					</c:if>
					<div class="form-group">
						<label for="name">Nom: </label> <input id="name" name="name"
							class="form-control" value="${ingredient.name}"
							<c:if test="${action.equals('Effacer')}">disabled=""</c:if> />
					</div>
					<div class="form-group">
						<label for="state">État: </label> <select class="form-control"
							id="state" name="state"
							<c:if test="${action.equals('Effacer')}">disabled=""</c:if>>
							<option value="" disabled
								<c:if test="${ingredient == null}">selected</c:if>>Choix
							</option>
							<c:set var="count" value="0" />
							<c:forEach items="${states}" var="state">
								<option value="${count}"
									<c:if test="${ingredient.state == state}">selected</c:if>>
									${state}</option>
								<c:set var="count" value="${count+1}" />
							</c:forEach>
						</select>
						<!-- <input type="number" min="0" max="2" id="state" name="state" class="form-control" /> -->
					</div>
					<!-- Button trigger modal -->
					<button type="button" class="btn btn-default" data-toggle="modal"
						data-target="#validationModal">Valider</button>
					<!-- <button class="btn btn-default">Valider</button> -->
				</fieldset>
				<!-- Modal -->
				<c:set var="entityName" value="l'ingrédient" />
				<%@include file="/inc/confirmModal.jsp" %>
			</form>
		</div>
	</div>
</div>
<jsp:include page="/inc/footer.jsp" />
