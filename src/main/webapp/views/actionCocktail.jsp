<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
		<div class="well bs-component col-md-8">
			<c:choose>
				<%--Action → Url --%>
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
					<div class="form-group col-md-5">
						<label for="name">Nom: </label> <input id="name" name="name"
							class="form-control" value="${cocktail.name}"
							<c:if test="${action.equals('Effacer')}">disabled=""</c:if> />
					</div>
					<div class="form-group col-md-5">
						<label for="name">Prix: </label> <input id="price" name="price"
							class="form-control" value="${cocktail.price}"
							<c:if test="${action.equals('Effacer')}">disabled=""</c:if> />
					</div>
					<div class="form-group col-md-2">
						<%-- -default if unchecked --%>
						<input type="hidden" name="alcoholic" value="0" /> <label
							for="alcoholic"> Alcoolisé:<input type="checkbox"
							id="alcoholic" name="alcoholic" class="form-control"
							<c:if test="${cocktail.alcoholic}">checked</c:if>
							<c:if test="${action.equals('Effacer')}">disabled=""</c:if>>
						</label>
					</div>
					<%--Ingredients table --%>
					<div class="row">
					<legend>Ingrédients</legend>
						<table id="cocktailIngredientsTable"
							class="table table-hover table-striped">
							<thead>
								<tr>
									<th>Id</th>
									<th>Nom</th>
									<th colspan="2">Quantité</th>
									<th></th>
									<%--action --%>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${cocktailIngredients}"
									var="cocktailIngredient">
									<tr>
										<td class="col-md-2">${cocktailIngredient.id}</td>
										<td class="col-md-4"><input id="name" name="name" class="form-control"
											<c:if test="${action.equals('Effacer')}">disabled=""</c:if>
											value="${cocktailIngredient.name}" /></td>
										<td class="col-md-2"><input id="qtNum" name="qtNum" class="form-control"
											<c:if test="${action.equals('Effacer')}">disabled=""</c:if>
											value="${cocktailIngredient.quantityNum}" /></td>
										<td class="col-md-2"><input id="qtDen" name="qtDen" class="form-control"
											<c:if test="${action.equals('Effacer')}">disabled=""</c:if>
											value="${cocktailIngredient.quantityDen}" /></td>
										<td class="col-md-2"><button class="btn btn-warning btn-xs">Supprimer</button>
									</tr>
								</c:forEach>
								<tr>
									<td class="col-md-2"></td>
									<%--id… --%>
									<td class="col-md-4"><select class="form-control" id="newIngredient"
										name="newIngredient"
										<c:if test="${action.equals('Effacer')}">disabled=""</c:if>>
											<option value="" disabled selected>Nouveau</option>
											<c:forEach items="${ingredients}" var="ingredient">
												<option value="${ingredient.id}">${ingredient.name}</option>
											</c:forEach>
									</select></td>
									<td class="col-md-2"><input id="newQtNum" name="newQtNum"
										class="form-control"
										<c:if test="${action.equals('Effacer')}">disabled=""</c:if> />
									</td>
									<td class="col-md-2"><input id="newQtDen" name="newQtDen"
										class="form-control"
										<c:if test="${action.equals('Effacer')}">disabled=""</c:if> />
									</td>
									<td class="col-md-2"><button class="btn btn-succes btn-xs">Ajouter</button>
								</tr>
							</tbody>
						</table>
											<%--envoyer la form… --%>
					<button type="button" class="btn btn-default col-md-2"
						data-toggle="modal" data-target="#validationModal">Valider</button>
					<%-- 					<button class="btn btn-default">Valider</button> --%>

					</div>
				</fieldset>
				<%-- Modal --%>
				<c:set var="entityName" value="le cocktail" />
				<%@ include file="/inc/confirmModal.jsp"%>
			</form>
		</div>
	</div>
</div>
<jsp:include page="/inc/footer.jsp" />
